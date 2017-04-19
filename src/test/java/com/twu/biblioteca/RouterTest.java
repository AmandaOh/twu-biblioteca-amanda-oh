package com.twu.biblioteca;

import org.junit.Test;

import static com.twu.biblioteca.BibliotecaApp.BOOK_REPO_PAGE;
import static com.twu.biblioteca.BibliotecaApp.MAIN_PAGE;
import static com.twu.biblioteca.BookRepositoryMenu.GO_BACK;
import static com.twu.biblioteca.BookRepositoryMenu.GO_BACK_COMMAND;
import static com.twu.biblioteca.MainMenu.*;
import static org.junit.Assert.*;

public class RouterTest {

    BookList books = new BookList();
    Router router = new Router(books);

    @Test
    public void getsMenuOptionWhenOnMainPage() throws Exception {
        MainMenu menu = new MainMenu();
        assertEquals(BOOK_LIST, router.delegate(MAIN_PAGE, menu, BOOK_LIST_COMMAND));
        assertEquals(EXIT, router.delegate(MAIN_PAGE, menu, EXIT_COMMAND));
    }


    @Test
    public void getsBookNameWhenOnBookRepoPage() {
        BookRepositoryMenu menu = new BookRepositoryMenu();
        assertEquals("Head First Java", router.delegate(BOOK_REPO_PAGE, menu, "1"));
    }

    @Test
    public void returnsExitValueWhenOnBookRepoPage() {
        BookRepositoryMenu menu = new BookRepositoryMenu();
        assertEquals(EXIT, router.delegate(BOOK_REPO_PAGE, menu, EXIT_COMMAND));
    }

    @Test
    public void returnsBackValueWhenOnBookRepoPage() {
        BookRepositoryMenu menu = new BookRepositoryMenu();
        assertEquals(GO_BACK, router.delegate(BOOK_REPO_PAGE, menu, GO_BACK_COMMAND));
    }

}