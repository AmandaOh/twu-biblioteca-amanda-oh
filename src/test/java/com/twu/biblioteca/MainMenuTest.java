package com.twu.biblioteca;

import com.twu.biblioteca.menus.MainMenu;
import org.junit.Test;

import static com.twu.biblioteca.menus.MainMenu.*;
import static org.junit.Assert.*;

public class MainMenuTest {
        MainMenu menu = new MainMenu(new BookRepository());

    @Test
    public void getOptionsShouldHaveOnlyTwoOption() throws Exception {
        assertTrue(menu.getOptions().size() == 2);
    }

    @Test
    public void getOption1shouldReturnBookListOption() {
        assertEquals(BOOK_LIST, menu.getOption(BOOK_LIST_COMMAND));
    }

    @Test
    public void getOption2shouldReturnInvalidOption() {
        assertEquals(NO_SUCH_OPTION, menu.getOption("2"));
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
        Router router = new Router(menu);
        assertEquals(BOOK_LIST, menu.executeRouterRequest(router, BOOK_LIST_COMMAND));
        assertEquals(EXIT, menu.executeRouterRequest(router, EXIT_COMMAND));
        assertEquals(NO_SUCH_OPTION, menu.executeRouterRequest(router, "B"));
    }

}