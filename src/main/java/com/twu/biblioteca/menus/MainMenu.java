package com.twu.biblioteca.menus;

import com.twu.biblioteca.Router;

import static com.twu.biblioteca.Router.*;

public class MainMenu extends Menu {

    public static final String BOOK_LIST = "Book List";
    public static final String BOOK_LIST_COMMAND = "1";
    public static final String RETURN_BOOK = "Return Book";
    public static final String RETURN_BOOK_COMMAND = "R";
    public static final String MOVIE_LIST = "Movie List";
    public static final String MOVIE_LIST_COMMAND = "2";

    protected String selectedOption;

    public MainMenu() {
        addOption(BOOK_LIST_COMMAND, BOOK_LIST);
        addOption(MOVIE_LIST_COMMAND, MOVIE_LIST);
        addOption(RETURN_BOOK_COMMAND, RETURN_BOOK);
        addOption(LOG_IN_COMMAND, LOG_IN);
        addOption(EXIT_COMMAND, EXIT);
    }

    @Override
    public String executeRouterRequest(Router router, String input) {
        selectedOption = super.executeRouterRequest(router, input);
        switch (selectedOption) {
            case BOOK_LIST:
                router.setState(BOOK_REPOSITORY_MENU_INDEX);
                break;
            case RETURN_BOOK:
                router.setState(RETURN_BOOK_MENU_INDEX);
                break;
            case MOVIE_LIST:
                router.setState(MOVIE_MENU_INDEX);
                break;
        }
        return selectedOption;
    }

    public String toString() {
        return super.toString() + "Please key your selection here: ";
    }
}
