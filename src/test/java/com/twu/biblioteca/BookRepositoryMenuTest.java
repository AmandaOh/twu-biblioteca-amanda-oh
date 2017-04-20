package com.twu.biblioteca;

import com.twu.biblioteca.menus.BookRepositoryMenu;
import org.junit.Test;

import static com.twu.biblioteca.menus.BookRepositoryMenu.GO_BACK;
import static org.junit.Assert.*;

public class BookRepositoryMenuTest {

    BookRepositoryMenu menu = new BookRepositoryMenu(new BookRepository());
    Router router = new Router(menu);

    @Test
    public void executeRequestRetrievesBookAccordingToRouterRequest() {
        String userInput = "1";
        assertEquals("Head First Java", menu.executeRouterRequest(router, userInput));
    }

    @Test
    public void executeRequestReturnsBackWhenUserSelectsBackCommand() {
        String userInput = "B";
        assertEquals(GO_BACK, menu.executeRouterRequest(router, userInput));
    }
}