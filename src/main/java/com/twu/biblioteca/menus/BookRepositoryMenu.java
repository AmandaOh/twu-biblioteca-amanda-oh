package com.twu.biblioteca.menus;
import com.twu.biblioteca.BookRepository;
import com.twu.biblioteca.Router;

public class BookRepositoryMenu extends Menu {

    public static final String FAIL_CHECK_OUT_MESSAGE = "Selected book is not available.";
    public static final String SUCCESSFUL_CHECK_OUT_MESSAGE = "Thank you enjoy the book!";

    private BookRepository books = new BookRepository();

    private String checkOutMessage = "";

    public BookRepositoryMenu() {
        addOption(GO_BACK_COMMAND, GO_BACK);
        addOption(EXIT_COMMAND, EXIT);
    }

    @Override
    public String executeRouterRequest(Router router, String input) {
        String selectedOption = this.getOption(input);
        if (selectedOption == NO_SUCH_OPTION) {
            selectedOption = books.checkOutBook(input);
            displayCheckOutMessage(selectedOption);
        } else if (selectedOption == GO_BACK) {
            router.setState(new MainMenu());
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
        String bookList = books.toString();
        return "\n" +  checkOutMessage + "\n\n" + bookList + "\n" + "SELECT book number FOR Check Out. \n" + super.toString();
    }

}
