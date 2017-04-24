package com.twu.biblioteca.menus;

import com.twu.biblioteca.Router;

import static com.twu.biblioteca.Router.BOOK_REPOSITORY_MENU_INDEX;
import static com.twu.biblioteca.Router.MOVIE_MENU_INDEX;
import static com.twu.biblioteca.Router.RETURN_BOOK_MENU_INDEX;

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
        addOption(EXIT_COMMAND, EXIT);
        addOption(RETURN_BOOK_COMMAND, RETURN_BOOK);
        addOption(MOVIE_LIST_COMMAND, MOVIE_LIST);
    }

    @Override
    public String executeRouterRequest(Router router, String input) {
        selectedOption = this.getOption(input);
        if(selectedOption == BOOK_LIST) {
            router.setState(BOOK_REPOSITORY_MENU_INDEX);
        } else if (selectedOption == RETURN_BOOK) {
            router.setState(RETURN_BOOK_MENU_INDEX);
        } else if (selectedOption == MOVIE_LIST) {
            router.setState(MOVIE_MENU_INDEX);
        }
        return selectedOption;
    }
}
