package com.twu.biblioteca;

import com.twu.biblioteca.menus.BookRepositoryMenu;
import com.twu.biblioteca.menus.MainMenu;
import com.twu.biblioteca.repositories.BookRepository;
import org.junit.Test;

import static com.twu.biblioteca.Router.BOOK_REPOSITORY_MENU_INDEX;
import static com.twu.biblioteca.Router.MAIN_MENU_INDEX;
import static com.twu.biblioteca.menus.BookRepositoryMenu.GO_BACK;
import static com.twu.biblioteca.menus.BookRepositoryMenu.GO_BACK_COMMAND;
import static com.twu.biblioteca.menus.MainMenu.*;
import static org.junit.Assert.*;

public class RouterTest {

    BookRepositoryMenu bookListMenu = new BookRepositoryMenu();
    Router router = new Router();

    @Test
    public void getsMenuOptionWhenOnMainPage() throws Exception {
        router.setState(MAIN_MENU_INDEX);
        assertEquals(BOOK_LIST, router.getSelectedOption(BOOK_LIST_COMMAND));
        assertEquals(EXIT, router.getSelectedOption(EXIT_COMMAND));
    }


    @Test
    public void getsBookNameWhenOnBookRepoPage() {
        router.setState(BOOK_REPOSITORY_MENU_INDEX);
        assertEquals("Head First Java", router.getSelectedOption("1"));
    }

    @Test
    public void returnsExitValueWhenOnBookRepoPage() {
        router.setState(BOOK_REPOSITORY_MENU_INDEX);
        assertEquals(EXIT, router.getSelectedOption(EXIT_COMMAND));
    }

    @Test
    public void returnsBackValueWhenOnBookRepoPage() {
        router.setState(BOOK_REPOSITORY_MENU_INDEX);
        assertEquals(GO_BACK, router.getSelectedOption(GO_BACK_COMMAND));
    }

}