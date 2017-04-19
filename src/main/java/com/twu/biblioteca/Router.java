package com.twu.biblioteca;

import static com.twu.biblioteca.BibliotecaApp.MAIN_PAGE;
import static com.twu.biblioteca.MainMenu.EXIT;
import static com.twu.biblioteca.MainMenu.NO_SUCH_OPTION;

public class Router {

    private BookList books;

    public Router(BookList books) {
        this.books = books;
    }

    public String delegate(int source, MainMenu menu, String input) {
        if (userInputsToExit(menu, input)) {return EXIT;}
        String selectedOption;
        if (source == MAIN_PAGE) {
            selectedOption = menu.getOption(input);
        } else {
            if (menu.getOption(input) != NO_SUCH_OPTION) {return menu.getOption(input);}
            try {
                selectedOption = books.getBook(input).getName();
            } catch (Exception e) {
                selectedOption = "";
            }
        }
        return selectedOption;
    }

    private boolean userInputsToExit(MainMenu menu, String input) {
        return menu.getOption(input) == EXIT;
    }

}
