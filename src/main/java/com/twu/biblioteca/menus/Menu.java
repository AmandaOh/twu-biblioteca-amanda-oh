package com.twu.biblioteca.menus;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.Router;
import com.twu.biblioteca.models.User;

import java.util.HashMap;
import java.util.Map;

import static com.twu.biblioteca.Router.LOG_IN_INDEX;
import static com.twu.biblioteca.Router.LOG_OUT_INDEX;
import static com.twu.biblioteca.Router.MAIN_MENU_INDEX;

public abstract class Menu {

    public static final String EXIT = "Exit";
    public static final String EXIT_COMMAND = "X";
    public static final String GO_BACK = "Back";
    public static final String GO_BACK_COMMAND = "B";
    public static final String NO_SUCH_OPTION = "Invalid Option";
    public static final String LOG_IN_COMMAND = "8";
    public static final String LOG_IN = "Log In";
    public static final String LOG_OUT_COMMAND = "9";
    public static final String LOG_OUT = "Log Out";

    private Map<String, String> options = new HashMap<>();
    User getLoggedInUser = Authenticator.getLoggedInUser();

    public void addOption(String shortCommand, String option) {
        this.options.put(shortCommand, option);
    }

    public Map<String, String> getOptions() {
        return this.options;
    }

    public String getOption(String s) {
        String userInput = s.toUpperCase();
        String option = this.options.get(userInput) == null ? NO_SUCH_OPTION : this.options.get(userInput);
        return option;
    }

    private void checkIfUserIsLoggedInToDisplayLogInOption() {
            if (getLoggedInUser == null) {
                addOption(LOG_IN_COMMAND, LOG_IN);
                removeOption(LOG_OUT_COMMAND);
            } else {
                addOption(LOG_OUT_COMMAND, LOG_OUT);
                removeOption(LOG_IN_COMMAND);
            }
    }

    public String toString() {
        checkIfUserIsLoggedInToDisplayLogInOption();
        StringBuilder menuOptions = new StringBuilder();
        for (Map.Entry<String, String> option : this.options.entrySet()) {
            menuOptions.append("SELECT [" + option.getKey() + "]");
            menuOptions.append(" FOR " + option.getValue());
            menuOptions.append("\n");
        }
        return "\n" + menuOptions.toString() + "\n";
    }

    public void removeOption(String shortCommand) {
        this.options.remove(shortCommand.toUpperCase());
    }

    //extract menu options
    public String executeRouterRequest(Router router, String input) {
        String selectedOption = getOption(input);
        switch (selectedOption) {
            case GO_BACK:
                router.setState(MAIN_MENU_INDEX);
                break;
            case LOG_IN:
                router.setState(LOG_IN_INDEX);
                break;
            case LOG_OUT:
                router.setState(LOG_OUT_INDEX);
                break;
        }
        return selectedOption;
    }

}
