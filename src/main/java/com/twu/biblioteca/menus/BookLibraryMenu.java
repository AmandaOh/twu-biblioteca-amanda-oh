package com.twu.biblioteca.menus;

import com.twu.biblioteca.Router;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.repositories.BookLibrary;

import static com.twu.biblioteca.Router.MAIN_MENU_INDEX;

public class BookLibraryMenu extends Menu {

    public static final String FAIL_CHECK_OUT_MESSAGE = "Selected book is not available.\n";
    public static final String SUCCESSFUL_CHECK_OUT_MESSAGE = "Thank you and enjoy!\n";

    public static final String CHECK_OUT_BOOK = "Check Out";

    private BookLibrary bookLibrary;

    private String checkOutMessage = "";

    public BookLibraryMenu(BookLibrary bookLibrary) {
        addOption(GO_BACK_COMMAND, GO_BACK);
        addOption(EXIT_COMMAND, EXIT);
        this.bookLibrary = bookLibrary;
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
        Book checkedOutBook = bookLibrary.checkOutBook(input);
        displayCheckOutMessage(checkedOutBook);
    }

    private void displayCheckOutMessage(Book checkedOutBook) {
        if (checkedOutBook == null) {
            checkOutMessage = FAIL_CHECK_OUT_MESSAGE;
        } else {
            checkOutMessage = "You have checked out " + checkedOutBook.getName() + ". " + SUCCESSFUL_CHECK_OUT_MESSAGE;
        }

    }

    public String toString() {
        bookLibrary.filterBooksByStatus(Book.Status.AVAILABLE);
        String bookList = bookLibrary.toString();
        return "\n" +  checkOutMessage + "\n\n" + bookList + "\n" + "SELECT book number FOR Check Out. \n" + super.toString();
    }

}
