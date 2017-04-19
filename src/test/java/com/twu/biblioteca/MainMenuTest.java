package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainMenuTest {
        MainMenu menu = new MainMenu();

    @Test
    public void getOptionsShouldHaveOnlyTwoOption() throws Exception {
        assertTrue(menu.getOptions().size() == 2);
    }

    @Test
    public void getOption1shouldReturnBookListOption() {
        assertEquals("Book List", menu.getOption("1"));
    }

    @Test
    public void getOption2shouldReturnInvalidOption() {
        assertEquals("Invalid Option", menu.getOption("2"));
    }

    @Test
    public void getOptionsShouldHaveExitOption() {
        assertTrue(menu.getOptions().containsValue("exit"));
    }

    @Test
    public void getOptionForCommandXShouldReturnExit() {
        assertEquals("exit", menu.getOption("x"));
    }
}