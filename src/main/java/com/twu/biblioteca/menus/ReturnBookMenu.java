package com.twu.biblioteca.menus;

import com.twu.biblioteca.Router;

import static com.twu.biblioteca.Router.MAIN_MENU_INDEX;

public class ReturnBookMenu extends Menu {

    public ReturnBookMenu() {
        addOption(GO_BACK_COMMAND, GO_BACK);
        addOption(EXIT_COMMAND, EXIT);
    }

    //FIX ME
    @Override
    public String executeRouterRequest(Router router, String input) {
        String selectedOption = this.getOption(input);
        if (selectedOption == GO_BACK) {
            router.setState(MAIN_MENU_INDEX);
        }
        else if (selectedOption == NO_SUCH_OPTION) {

        }
        return selectedOption;
    }
}
