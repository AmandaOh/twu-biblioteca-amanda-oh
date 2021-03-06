package com.twu.biblioteca.menus;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.Router;
import com.twu.biblioteca.repositories.Library;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static com.twu.biblioteca.menus.BookLibraryMenu.GO_BACK;
import static com.twu.biblioteca.menus.BookLibraryMenu.GO_BACK_COMMAND;
import static com.twu.biblioteca.menus.MainMenu.EXIT;
import static org.junit.Assert.*;

public class ReturnBookMenuTest {

    Authenticator authenticator = new Authenticator(new HashMap<>());
    Library library = new Library(new ArrayList<>());
    Router router = new Router(authenticator, library);

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