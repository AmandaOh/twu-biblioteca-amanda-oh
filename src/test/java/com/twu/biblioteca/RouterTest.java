package com.twu.biblioteca;

import com.twu.biblioteca.menus.BookRepositoryMenu;
import com.twu.biblioteca.menus.MainMenu;
import org.junit.Test;

import static com.twu.biblioteca.menus.BookRepositoryMenu.GO_BACK;
import static com.twu.biblioteca.menus.BookRepositoryMenu.GO_BACK_COMMAND;
import static com.twu.biblioteca.menus.MainMenu.*;
import static org.junit.Assert.*;

public class RouterTest {

    BookRepository books = new BookRepository();
    BookRepositoryMenu bookListMenu = new BookRepositoryMenu();
    Router router = new Router(bookListMenu);

    @Test
    public void getsMenuOptionWhenOnMainPage() throws Exception {
        router = new Router (new MainMenu());
        assertEquals(BOOK_LIST, router.getSelectedOption(BOOK_LIST_COMMAND));
        assertEquals(EXIT, router.getSelectedOption(EXIT_COMMAND));
    }


    @Test
    public void getsBookNameWhenOnBookRepoPage() {
        router.setState(bookListMenu);
        assertEquals("Head First Java", router.getSelectedOption("1"));
    }

    @Test
    public void returnsExitValueWhenOnBookRepoPage() {
        router.setState(bookListMenu);
        assertEquals(EXIT, router.getSelectedOption(EXIT_COMMAND));
    }

    @Test
    public void returnsBackValueWhenOnBookRepoPage() {
        router.setState(bookListMenu);
        assertEquals(GO_BACK, router.getSelectedOption(GO_BACK_COMMAND));
    }

}