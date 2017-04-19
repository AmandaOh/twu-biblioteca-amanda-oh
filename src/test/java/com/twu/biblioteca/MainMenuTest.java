package com.twu.biblioteca;

import org.junit.Test;

import static com.twu.biblioteca.MainMenu.BOOK_LIST;
import static com.twu.biblioteca.MainMenu.EXIT;
import static com.twu.biblioteca.MainMenu.NO_SUCH_OPTION;
import static org.junit.Assert.*;

public class MainMenuTest {
        MainMenu menu = new MainMenu();

    @Test
    public void getOptionsShouldHaveOnlyTwoOption() throws Exception {
        assertTrue(menu.getOptions().size() == 2);
    }

    @Test
    public void getOption1shouldReturnBookListOption() {
        assertEquals(BOOK_LIST, menu.getOption("1"));
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
        assertEquals(EXIT, menu.getOption("x"));
    }

    @Test
    public void removeBookListOptionDeletesOptionFromMainMenu() {
        menu.removeOption("1");
        assertFalse(menu.getOptions().containsValue(BOOK_LIST));
        assertTrue(menu.getOptions().containsValue(EXIT));
    }

}