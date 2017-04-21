package com.twu.biblioteca.menus;

import com.twu.biblioteca.BookRepository;
import com.twu.biblioteca.Router;

import java.util.HashMap;
import java.util.Map;

public class MainMenu extends Menu {

    public static final String BOOK_LIST = "Book List";
    public static final String BOOK_LIST_COMMAND = "1";
    public static final String RETURN_BOOK = "Return Book";
    public static final String RETURN_BOOK_COMMAND = "R";

    private Map<String, String> options = new HashMap<String, String>();
    protected String selectedOption;

    public MainMenu() {
        addOption(BOOK_LIST_COMMAND, BOOK_LIST);
        addOption(EXIT_COMMAND, EXIT);
        addOption(RETURN_BOOK_COMMAND, RETURN_BOOK);
    }

    @Override
    public String executeRouterRequest(Router router, String input) {
        selectedOption = this.getOption(input);
        if(selectedOption == BOOK_LIST) {
            router.setState(new BookRepositoryMenu());
        } else if (selectedOption == RETURN_BOOK) {
            router.setState(new ReturnBookMenu());
        }
        return selectedOption;
    }
}
