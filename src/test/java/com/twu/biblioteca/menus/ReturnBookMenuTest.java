package com.twu.biblioteca.menus;

import com.twu.biblioteca.Router;
import com.twu.biblioteca.repositories.BookLibrary;
import org.junit.Test;

import java.util.ArrayList;

import static com.twu.biblioteca.menus.BookLibraryMenu.GO_BACK;
import static com.twu.biblioteca.menus.BookLibraryMenu.GO_BACK_COMMAND;
import static com.twu.biblioteca.menus.MainMenu.EXIT;
import static org.junit.Assert.*;

public class ReturnBookMenuTest {

    BookLibrary library = new BookLibrary(new ArrayList<>());
    Router router = new Router(library);

    ReturnBookMenu menu = new ReturnBookMenu(library);

    @Test
    public void menuShouldContain2OptionsToGoBackOrExit() {
        assertTrue(menu.getOptions().size() == 2);
        assertTrue(menu.getOptions().containsValue(GO_BACK));
        assertTrue(menu.getOptions().containsValue(EXIT));
    }

    @Test
    public void executeRouterRequestShouldReturnExitWhenInputIsExitCommand() {
        assertEquals(EXIT, menu.executeRouterRequest(router, "x"));
    }

    @Test
    public void executeRouterRequestShouldReturnGoBackWhenInputIsGoBackCommand() {
        assertEquals(GO_BACK, menu.executeRouterRequest(router, GO_BACK_COMMAND));
    }



}