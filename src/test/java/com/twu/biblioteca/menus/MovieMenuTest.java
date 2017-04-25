package com.twu.biblioteca.menus;

import com.twu.biblioteca.Router;
import com.twu.biblioteca.repositories.Library;
import org.junit.Test;

import java.util.ArrayList;

import static com.twu.biblioteca.menus.Menu.GO_BACK;
import static com.twu.biblioteca.menus.Menu.GO_BACK_COMMAND;
import static org.junit.Assert.assertEquals;

public class MovieMenuTest {

    Library library = new Library(new ArrayList<>());
    MovieMenu menu = new MovieMenu(library);
    Router router = new Router(library);

    @Test
    public void executeRouterRequestShouldReturnBackWhenUserSelectsGoBackOption() throws Exception {
        assertEquals(GO_BACK, menu.executeRouterRequest(router, GO_BACK_COMMAND));
    }


}