package com.twu.biblioteca;

import com.twu.biblioteca.menus.BookRepositoryMenu;
import com.twu.biblioteca.menus.MainMenu;
import com.twu.biblioteca.menus.Menu;
import com.twu.biblioteca.menus.ReturnBookMenu;

public class Router {

    public static final int MAIN_MENU_INDEX = 0;
    public static final int BOOK_REPOSITORY_MENU_INDEX = 1;
    public static final int RETURN_BOOK_MENU_INDEX = 2;

    private Menu[] menus = {new MainMenu(), new BookRepositoryMenu(), new ReturnBookMenu()};
    private Menu currentMenu;

    public Router() {
        currentMenu = menus[0];
    }

    public String getSelectedOption(String input) {
        return currentMenu.executeRouterRequest(this, input);
    }

    public void setState(int menuIndex){
        currentMenu = menus[menuIndex];
    }

    public String getPrintedResponse() {
        return currentMenu.toString();
    }
}
