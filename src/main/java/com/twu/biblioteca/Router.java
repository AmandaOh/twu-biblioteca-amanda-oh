package com.twu.biblioteca;

import com.twu.biblioteca.menus.*;
import com.twu.biblioteca.repositories.BookLibrary;

public class Router {

    public static final int MAIN_MENU_INDEX = 0;
    public static final int BOOK_REPOSITORY_MENU_INDEX = 1;
    public static final int RETURN_BOOK_MENU_INDEX = 2;
    public static final int MOVIE_MENU_INDEX = 3;

    private Menu[] menus;
    private Menu currentMenu;

    public Router(BookLibrary library) {
        menus = new Menu[]{new MainMenu(), new BookLibraryMenu(library), new ReturnBookMenu(library), new MovieMenu()};
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
