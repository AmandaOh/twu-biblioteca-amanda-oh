package com.twu.biblioteca.menus;

import com.twu.biblioteca.Router;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Loanable;
import com.twu.biblioteca.repositories.Library;

import java.util.List;

import static com.twu.biblioteca.Router.MAIN_MENU_INDEX;
import static com.twu.biblioteca.models.Loanable.Status.AVAILABLE;

public class BookLibraryMenu extends Menu {

    public static final String FAIL_CHECK_OUT_MESSAGE = "Selected item is not available.\n";
    public static final String SUCCESSFUL_CHECK_OUT_MESSAGE = "Thank you and enjoy!\n";

    public static final String CHECK_OUT_BOOK = "Check Out";

    private Library library;

    private String checkOutMessage = "";

    public BookLibraryMenu(Library library) {
        addOption(GO_BACK_COMMAND, GO_BACK);
        addOption(EXIT_COMMAND, EXIT);
        this.library = library;
    }

    @Override
    public String executeRouterRequest(Router router, String input) {
        String selectedOption = getOption(input);
        if (selectedOption.equals(EXIT)) {
            return EXIT;
        } else if (selectedOption.equals(GO_BACK)) {
            router.setState(MAIN_MENU_INDEX);
            checkOutMessage = "";
        } else {
            selectedOption = CHECK_OUT_BOOK;
            processCheckOut(input);
        }
        return selectedOption;
    }

    private void processCheckOut(String input) {
        Loanable checkedOutBook = library.checkOut(input, Book.class);
        displayCheckOutMessage(checkedOutBook);
    }

    private void displayCheckOutMessage(Loanable checkedOutBook) {
        Book book = (Book) checkedOutBook;
        if (book == null) {
            checkOutMessage = FAIL_CHECK_OUT_MESSAGE;
        } else {
            checkOutMessage = "You have checked out " + book.getName() + ". " + SUCCESSFUL_CHECK_OUT_MESSAGE;
        }

    }

    public String toString() {
        List<Loanable> bookList = library.filterBy(AVAILABLE, Book.class);
        StringBuilder table = new StringBuilder();
        for (int i = 0; i < bookList.size(); i++) {
            Book book = (Book) bookList.get(i);
            table.append(Integer.toString(i + 1) + "| ");
            table.append(book.getName());
            table.append(" ");
            table.append(book.getAuthor());
            table.append(" ");
            table.append(book.getYear());
            //            table.append(" ");
            //            table.append(book.getStatus());
            table.append("\n");
        }
        return "\n" + checkOutMessage + "\nLIST OF BOOKS\n" + table.toString() +  "\nSELECT book number FOR Check Out.\n" + super.toString();
    }

}
