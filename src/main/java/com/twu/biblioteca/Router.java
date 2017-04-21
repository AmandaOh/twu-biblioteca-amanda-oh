package com.twu.biblioteca;

import com.twu.biblioteca.menus.Menu;

public class Router {

    private Menu currentMenu;

    public Router(Menu menu) {
        currentMenu = menu;
    }

    public String getSelectedOption(String input) {
        return currentMenu.executeRouterRequest(this, input);
    }

    public void setState(Menu state){
        currentMenu = state;
    }

    public String getPrintedResponse() {
        return currentMenu.toString();
    }
}
