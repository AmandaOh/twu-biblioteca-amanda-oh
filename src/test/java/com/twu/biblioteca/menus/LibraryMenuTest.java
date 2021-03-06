package com.twu.biblioteca.menus;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.Router;
import com.twu.biblioteca.repositories.Library;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static com.twu.biblioteca.menus.BookLibraryMenu.CHECK_OUT_BOOK;
import static com.twu.biblioteca.menus.BookLibraryMenu.GO_BACK;
import static org.junit.Assert.assertEquals;


public class LibraryMenuTest {



    Library library = new Library(new ArrayList<>());
    BookLibraryMenu menu = new BookLibraryMenu(library);
    Authenticator authenticator = new Authenticator(new HashMap<>());
    Router router = new Router(authenticator, library);

    @Test
    public void executeRequestReturnsBackWhenUserSelectsBackCommand() {
        String userInput = "B";
        assertEquals(GO_BACK, menu.executeRouterRequest(router, userInput));
    }

    @Test
    public void executeRequestReturnsCheckOutOptionWhenUserSelectsAnyCommandButBackAndExit() {
        assertEquals(CHECK_OUT_BOOK, menu.executeRouterRequest(router, "23948"));
    }


}