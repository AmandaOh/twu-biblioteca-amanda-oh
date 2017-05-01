package com.twu.biblioteca;

import com.twu.biblioteca.menus.*;
import com.twu.biblioteca.repositories.Library;

public class Router {

    public static final int MAIN_MENU_INDEX = 0;
    public static final int BOOK_REPOSITORY_MENU_INDEX = 1;
    public static final int RETURN_BOOK_MENU_INDEX = 2;
    public static final int MOVIE_MENU_INDEX = 3;
    public static final int LOG_IN_INDEX = 4;
    public static final int LOG_OUT_INDEX = 5;

    private Menu[] menus;
    private Menu currentMenu;

    public Router(Authenticator authenticator, Library library) {
        menus = new Menu[]{new MainMenu(), new BookLibraryMenu(library), new ReturnBookMenu(library), new MovieMenu(library), new LogInMenu(authenticator), new LogOutMenu(authenticator)};
        currentMenu = menus[MAIN_MENU_INDEX];
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
