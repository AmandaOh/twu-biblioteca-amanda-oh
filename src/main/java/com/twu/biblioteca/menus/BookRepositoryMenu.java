package com.twu.biblioteca.menus;
import com.twu.biblioteca.Router;
import com.twu.biblioteca.repositories.BookRepository;

import static com.twu.biblioteca.Router.MAIN_MENU_INDEX;

public class BookRepositoryMenu extends Menu {

    public static final String FAIL_CHECK_OUT_MESSAGE = "Selected book is not available.";
    public static final String SUCCESSFUL_CHECK_OUT_MESSAGE = "Thank you enjoy the book!";

    private BookRepository bookRepository = new BookRepository(this);

    private String checkOutMessage = "";

    public BookRepositoryMenu() {
        addOption(GO_BACK_COMMAND, GO_BACK);
        addOption(EXIT_COMMAND, EXIT);
    }

    @Override
    public String executeRouterRequest(Router router, String input) {
        String selectedOption = getOption(input);
        if (selectedOption == NO_SUCH_OPTION) {
            selectedOption = bookRepository.checkOutBook(input);
            displayCheckOutMessage(selectedOption);
        } else if (selectedOption == GO_BACK) {
            router.setState(MAIN_MENU_INDEX);
        }
        return selectedOption;
    }

    private void displayCheckOutMessage(String selectedOption) {
        if (selectedOption == null) {
            checkOutMessage = FAIL_CHECK_OUT_MESSAGE;
        } else {
            checkOutMessage = "You have checked out " + selectedOption + ". " + SUCCESSFUL_CHECK_OUT_MESSAGE;
        }

    }

    public String toString() {
        String bookList = bookRepository.toString();
        return "\n" +  checkOutMessage + "\n\n" + bookList + "\n" + "SELECT book number FOR Check Out. \n" + super.toString();
    }

}
