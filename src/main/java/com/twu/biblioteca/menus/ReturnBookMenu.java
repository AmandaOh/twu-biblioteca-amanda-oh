package com.twu.biblioteca.menus;

import com.twu.biblioteca.Router;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.repositories.BookLibrary;

import static com.twu.biblioteca.Router.MAIN_MENU_INDEX;

public class ReturnBookMenu extends Menu {

    public static final String SUCCESSFUL_RETURN_MESSAGE = "\nThank you for returning ";
    public static final String FAIL_RETURN_MESSAGE = "\nThat is not a valid book to return.\n";

    private static final String RETURN_BOOK = "Return Book";

    private BookLibrary bookLibrary;

    private String bookReturnMessage = "";

    public ReturnBookMenu(BookLibrary library) {
        addOption(GO_BACK_COMMAND, GO_BACK);
        addOption(EXIT_COMMAND, EXIT);
        bookLibrary = library;
    }

    @Override
    public String executeRouterRequest(Router router, String input) {
        String selectedOption = getOption(input);
        if (selectedOption.equals(EXIT)) {
            return EXIT;
        } else if (selectedOption == GO_BACK) {
            router.setState(MAIN_MENU_INDEX);
            bookReturnMessage = "";
        } else {
            selectedOption = RETURN_BOOK;
            processReturn(input);
        }
        return selectedOption;
    }

    private void processReturn(String input) {
        Book returnBook = bookLibrary.returnBook(input);
        displayReturnMessage(returnBook);
    }

    private void displayReturnMessage(Book returnBook) {
        if (returnBook == null) {
            bookReturnMessage = FAIL_RETURN_MESSAGE;
        } else {
            bookReturnMessage = SUCCESSFUL_RETURN_MESSAGE + returnBook.getName() + "!\n";
        }
    }

    public String toString() {
        bookLibrary.filterBooksByStatus(Book.Status.NOT_AVAILABLE);
        String borrowedBookList = bookLibrary.toString();
        return bookReturnMessage + "\n" + borrowedBookList + "\n" + "SELECT book number FOR book returns. \n" + super.toString();
    }

}
