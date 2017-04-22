package com.twu.biblioteca.menus;

import com.twu.biblioteca.Router;
import org.junit.Test;

import static com.twu.biblioteca.menus.BookRepositoryMenu.GO_BACK;
import static org.junit.Assert.*;

public class BookRepositoryMenuTest {

    BookRepositoryMenu menu = new BookRepositoryMenu();
    Router router = new Router();


    @Test
    public void executeRequestReturnsBackWhenUserSelectsBackCommand() {
        String userInput = "B";
        assertEquals(GO_BACK, menu.executeRouterRequest(router, userInput));
    }

    @Test
    public void executeRequestReturnsNullWhenUserSelectsBookNotAvailable() {
        assertNull(menu.executeRouterRequest(router, "23948"));
    }

    //Test to run on its own
    @Test
    public void executeRequestRetrievesBookAccordingToRouterRequest() {
        String userInput = "1";
        assertEquals("Head First Java", menu.executeRouterRequest(router, userInput));
    }


}