package com.twu.biblioteca.menus;

import com.twu.biblioteca.BookRepository;
import com.twu.biblioteca.Router;

public class BookRepositoryMenu extends MainMenu {

    public static final String GO_BACK = "Back";
    public static final String GO_BACK_COMMAND = "B";

    public static final String FAIL_CHECK_OUT_MESSAGE = "Selected book is not available.";
    public static final String SUCCESSFUL_CHECK_OUT_MESSAGE = "Checkout successful!";

    private String checkOutMessage = "";

    public BookRepositoryMenu(BookRepository books) {
        super(books);
        addOption(GO_BACK_COMMAND, GO_BACK);
        removeOption(BOOK_LIST_COMMAND);
    }

    public String executeRouterRequest(Router router, String input) {
        selectedOption = this.getOption(input);
        if (selectedOption == NO_SUCH_OPTION) {
            selectedOption = books.checkOutBook(input);
            displayCheckOutMessage(selectedOption);
        } else if (selectedOption == GO_BACK) {
            router.setState(new MainMenu(books));
        }
        return selectedOption;
    }

    private void displayCheckOutMessage(String selectedOption) {
        if (selectedOption == null) {
            checkOutMessage = FAIL_CHECK_OUT_MESSAGE;
        } else {
            checkOutMessage = "You have selected " + selectedOption + ". " + SUCCESSFUL_CHECK_OUT_MESSAGE;
        }

    }

    public String toString() {
        String bookList = books.toString();
        return "\n" + bookList + "\n" + checkOutMessage + "\n" + "SELECT book number FOR Check Out. \n" + super.toString();
    }

}
