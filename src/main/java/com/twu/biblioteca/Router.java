package com.twu.biblioteca;

import com.twu.biblioteca.menus.MainMenu;

public class Router {

    private MainMenu currentMenu;

    public Router(MainMenu menu) {
        currentMenu = menu;
    }

    public String getSelectedOption(String input) {
        return currentMenu.executeRouterRequest(this, input);
    }

    public void setState(MainMenu state){
        currentMenu = state;
    }

    public String getPrintedResponse() {
        return currentMenu.toString();
    }
}
