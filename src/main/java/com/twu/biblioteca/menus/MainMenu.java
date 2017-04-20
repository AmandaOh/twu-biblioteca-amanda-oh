package com.twu.biblioteca.menus;

import com.twu.biblioteca.BookRepository;
import com.twu.biblioteca.Router;

import java.util.HashMap;
import java.util.Map;

public class MainMenu implements Menu {

    public static final String BOOK_LIST = "Book List";
    public static final String BOOK_LIST_COMMAND = "1";
    public static final String EXIT = "Exit";
    public static final String EXIT_COMMAND = "X";
    public static final String NO_SUCH_OPTION = "Invalid Option";

    private Map<String, String> options = new HashMap<String, String>();
    protected BookRepository books;
    protected String selectedOption;

    public MainMenu(BookRepository books) {
        this.books = books;
        addOption(BOOK_LIST_COMMAND, BOOK_LIST);
        addOption(EXIT_COMMAND, EXIT);
    }


    public void addOption(String shortCommand, String option) {
        options.put(shortCommand, option);
    }


    public Map<String, String> getOptions() {
        return options;
    }

    public String getOption(String s) {
        String userInput = s.toUpperCase();
        String option = options.get(userInput) == null ? NO_SUCH_OPTION : options.get(userInput);
        return option;
    }

    public String toString() {
        StringBuilder menuOptions = new StringBuilder();
        for(Map.Entry<String, String> option : options.entrySet()) {
            menuOptions.append("SELECT [" + option.getKey() + "]");
            menuOptions.append(" FOR " + option.getValue());
            menuOptions.append("\n");
        }
        return "\n" + menuOptions.toString() + "\n" + "Please key your selection here: ";
    }

    public void removeOption(String shortCommand) {
        options.remove(shortCommand.toLowerCase());
    }

    @Override
    public String executeRouterRequest(Router router, String input) {
        selectedOption = this.getOption(input);
        if(selectedOption == BOOK_LIST) {
            router.setState(new BookRepositoryMenu(books));
        }
        return selectedOption;
    }
}
