package com.twu.biblioteca.menus;

import com.twu.biblioteca.Router;
import com.twu.biblioteca.repositories.BookLibrary;
import org.junit.Test;

import java.util.ArrayList;

import static com.twu.biblioteca.menus.BookLibraryMenu.CHECK_OUT_BOOK;
import static com.twu.biblioteca.menus.BookLibraryMenu.GO_BACK;
import static org.junit.Assert.assertEquals;


public class BookLibraryMenuTest {



    BookLibrary library = new BookLibrary(new ArrayList<>());
    BookLibraryMenu menu = new BookLibraryMenu(library);
    Router router = new Router(library);

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