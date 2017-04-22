package com.twu.biblioteca.menus;

import com.twu.biblioteca.Router;
import com.twu.biblioteca.repositories.CheckedOutBooksRepository;

import static com.twu.biblioteca.Router.MAIN_MENU_INDEX;

public class ReturnBookMenu extends Menu {

    public static final String SUCCESSFUL_RETURN_MESSAGE = "Thank you for returning ";
    public static final String FAIL_RETURN_MESSAGE = "That is not a valid book to return.";

    private CheckedOutBooksRepository checkedOutBooksRepository = new CheckedOutBooksRepository();

    private String bookReturnMessage = "";

    public ReturnBookMenu() {
        addOption(GO_BACK_COMMAND, GO_BACK);
        addOption(EXIT_COMMAND, EXIT);
    }

    @Override
    public String executeRouterRequest(Router router, String input) {
        String selectedOption = getOption(input);
        if (selectedOption == NO_SUCH_OPTION) {
            selectedOption = checkedOutBooksRepository.returnBook(input);
            displayReturnMessage(selectedOption);
        } else if (selectedOption == GO_BACK) {
            router.setState(MAIN_MENU_INDEX);
        }
        return selectedOption;
    }

    private void displayReturnMessage(String selectedOption) {
        if (selectedOption == null) {
            bookReturnMessage = FAIL_RETURN_MESSAGE;
        } else {
            bookReturnMessage = SUCCESSFUL_RETURN_MESSAGE + selectedOption + "!";
        }
    }

    public String toString() {
        String borrowedBookList = checkedOutBooksRepository.toString();
        return "\n" + bookReturnMessage +  "\n\n" + borrowedBookList + "\n" + "SELECT book number FOR book returns. \n" + super.toString();
    }

}
