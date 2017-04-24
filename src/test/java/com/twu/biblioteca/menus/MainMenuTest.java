package com.twu.biblioteca.menus;

import com.twu.biblioteca.Router;
import com.twu.biblioteca.repositories.BookLibrary;
import org.junit.Test;

import java.util.ArrayList;

import static com.twu.biblioteca.menus.MainMenu.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MainMenuTest {

    MainMenu menu = new MainMenu();

    @Test
    public void getOptionsShouldHaveOnlyFourOptions() throws Exception {
        assertTrue(menu.getOptions().size() == 4);
    }

    @Test
    public void getOption1shouldReturnBookListOption() {
        assertEquals(BOOK_LIST, menu.getOption(BOOK_LIST_COMMAND));
    }

    @Test
    public void getOption10shouldReturnInvalidOption() {
        assertEquals(NO_SUCH_OPTION, menu.getOption("10"));
    }

    @Test
    public void getOptionsShouldHaveExitOption() {
        assertTrue(menu.getOptions().containsValue(EXIT));
    }

    @Test
    public void getOptionForCommandXShouldReturnExit() {
        assertEquals(EXIT, menu.getOption(EXIT_COMMAND));
    }

    @Test
    public void removeBookListOptionDeletesOptionFromMainMenu() {
        menu.removeOption(BOOK_LIST_COMMAND);
        assertFalse(menu.getOptions().containsValue(BOOK_LIST));
        assertTrue(menu.getOptions().containsValue(EXIT));
    }

    @Test
    public void executeRequestShouldReturnOnlyValidOptionsForMainMenu() {
        BookLibrary library = new BookLibrary(new ArrayList<>());
        Router router = new Router(library);
        assertEquals(BOOK_LIST, menu.executeRouterRequest(router, BOOK_LIST_COMMAND));
        assertEquals(EXIT, menu.executeRouterRequest(router, EXIT_COMMAND));
        assertEquals(NO_SUCH_OPTION, menu.executeRouterRequest(router, "b"));
        assertEquals(MOVIE_LIST, menu.executeRouterRequest(router, MOVIE_LIST_COMMAND));
    }

    @Test
    public void getOptionsShouldHaveMoveListOption() {
        assertTrue(menu.getOptions().containsValue(MOVIE_LIST));
    }


}
