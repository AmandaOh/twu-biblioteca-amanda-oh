package com.twu.biblioteca.menus;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.Router;

import static com.twu.biblioteca.Router.MAIN_MENU_INDEX;

public class LogOutMenu extends Menu{

    private Authenticator authenticator;

    public LogOutMenu(Authenticator authenticator) {
        addOption(GO_BACK_COMMAND, GO_BACK);
        addOption(EXIT_COMMAND, EXIT);
        addOption(LOG_OUT_COMMAND, LOG_OUT);
        this.authenticator = authenticator;
    }

    @Override
    public String executeRouterRequest(Router router, String input) {
        String selectedOption = getOption(input);
        if (selectedOption.equals(GO_BACK)) {
            router.setState(MAIN_MENU_INDEX);
        }
        else if (selectedOption.equals(LOG_OUT)) {
            authenticator.terminate();
        }
        return selectedOption;
    }

    public String toString() {
        String prompt;
        if (authenticator.getLoggedInUser() == null) {
            prompt = "You are not logged in.";
        } else {
            prompt = "You are logged in as " + authenticator.getLoggedInUser().getName() + ". Log Out?";
        }
        return super.toString() + prompt;
    }
}
