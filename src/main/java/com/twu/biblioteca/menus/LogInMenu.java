package com.twu.biblioteca.menus;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.Router;
import com.twu.biblioteca.models.User;

import static com.twu.biblioteca.Router.MAIN_MENU_INDEX;

public class LogInMenu extends Menu {

    private static final int KEY_USERNAME = 0;
    private static final int KEY_PASSWORD = 1;
    private static final int ALREADY_LOGGED_IN = 2;

    private String libraryNumber;

    Authenticator authenticator;
    int userInputStage = KEY_USERNAME;

    public LogInMenu(Authenticator authenticator) {
        addOption(GO_BACK_COMMAND, GO_BACK);
        addOption(EXIT_COMMAND, EXIT);
        this.authenticator = authenticator;
    }

    @Override
    public String executeRouterRequest(Router router, String input) {
        String selectedOption = getOption(input);
        if (selectedOption.equals(GO_BACK)) {
            router.setState(MAIN_MENU_INDEX);
        }
        tryToAuthenticate(router, input);
        return selectedOption;
    }

    private void tryToAuthenticate(Router router, String input) {
        if (userInputStage == KEY_USERNAME) {
            User user = authenticator.getUser(input);
            if (user != null) {
                userInputStage = KEY_PASSWORD;
                libraryNumber = input;
            } else {
                System.out.print("No such user.");
            }
        } else if (userInputStage == KEY_PASSWORD) {
            if(authenticator.authenticate(libraryNumber, input)) {
                userInputStage = ALREADY_LOGGED_IN;
                System.out.println("Successfully logged in as " + authenticator.getLoggedInUser().getName() + ".");
                router.setState(MAIN_MENU_INDEX);
            } else {
                System.out.println("Password does not match our records.");
            }

        }
    }

    public String toString() {
        String displayPrompt;
        if (userInputStage == KEY_USERNAME) {
            displayPrompt = super.toString() +  "Library Number:";
        }
        else if (userInputStage == KEY_PASSWORD) {
            displayPrompt = "Password:";
        }
        else {
            displayPrompt = "You are already logged in as " + authenticator.getLoggedInUser().getName();
        }
        return displayPrompt;
    }

}
