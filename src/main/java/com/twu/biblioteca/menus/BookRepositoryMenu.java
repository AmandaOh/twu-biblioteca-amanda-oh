package com.twu.biblioteca.menus;

import com.twu.biblioteca.BookRepository;
import com.twu.biblioteca.Router;
import com.twu.biblioteca.menus.MainMenu;

public class BookRepositoryMenu extends MainMenu {

    public static final String GO_BACK = "Back";
    public static final String GO_BACK_COMMAND = "B";

    public BookRepositoryMenu(BookRepository books) {
        super(books);
        addOption(GO_BACK_COMMAND, GO_BACK);
        removeOption(BOOK_LIST_COMMAND);
    }

    public String executeRouterRequest(Router router, String input) {
        this.selectedOption= this.getOption(input);
        if (selectedOption == NO_SUCH_OPTION) {
            try {
                selectedOption = books.getBook(input).getName();
            } catch (Exception e) {
                selectedOption = "Please select a valid option.";
            }
        } else if (selectedOption == GO_BACK) {
            router.setState(new MainMenu(books));
        }
        return selectedOption;
    }

    public String toString() {
        String bookList = this.books.toString();
        return "\n" + bookList + "\n" + "SELECT book number FOR Check Out. \n" + super.toString();
    }

}
