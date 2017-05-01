package com.twu.biblioteca;

import com.twu.biblioteca.models.Loanable;
import com.twu.biblioteca.repositories.Library;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.twu.biblioteca.Router.BOOK_REPOSITORY_MENU_INDEX;
import static com.twu.biblioteca.Router.MAIN_MENU_INDEX;
import static com.twu.biblioteca.menus.BookLibraryMenu.*;
import static com.twu.biblioteca.menus.BookLibraryMenu.GO_BACK;
import static com.twu.biblioteca.menus.BookLibraryMenu.GO_BACK_COMMAND;
import static com.twu.biblioteca.menus.MainMenu.*;
import static com.twu.biblioteca.menus.MainMenu.EXIT;
import static com.twu.biblioteca.menus.MainMenu.EXIT_COMMAND;
import static org.junit.Assert.assertEquals;

public class RouterTest {

    List<Loanable> books = new ArrayList<>();
    Library library = new Library(books);
    Authenticator authenticator = new Authenticator(new HashMap<>());
    Router router = new Router(authenticator, library);

//    @Before
//    public void loadBooksForTestCase() {
//        Book book1 = new Book("Moneyball", new ArrayList<>(Arrays.asList("Michael Lewis")), 2003);
//        Book book2 = new Book("The Great Gatsby", new ArrayList<>(Arrays.asList("F. Scott Fitzgerald")), 2004);
//        Book book3 = new Book("Lean In", new ArrayList<>(Arrays.asList("Sheryl Sandberg")), 2013);
//        books.add(book1);
//        books.add(book2);
//        books.add(book3);
//    }

    @Test
    public void getsMenuOptionWhenOnMainPage() throws Exception {
        router.setState(MAIN_MENU_INDEX);
        assertEquals(BOOK_LIST, router.getSelectedOption(BOOK_LIST_COMMAND));
        assertEquals(EXIT, router.getSelectedOption(EXIT_COMMAND));
    }


    @Test
    public void getsCheckOutBookOptionWhenOnBookLibraryPage() {
        router.setState(BOOK_REPOSITORY_MENU_INDEX);
        assertEquals(CHECK_OUT_BOOK, router.getSelectedOption("1"));
    }

    @Test
    public void returnsExitValueWhenOnBookLibraryPage() {
        router.setState(BOOK_REPOSITORY_MENU_INDEX);
        assertEquals(EXIT, router.getSelectedOption(EXIT_COMMAND));
    }

    @Test
    public void returnsBackValueWhenOnBookLibraryPage() {
        router.setState(BOOK_REPOSITORY_MENU_INDEX);
        assertEquals(GO_BACK, router.getSelectedOption(GO_BACK_COMMAND));
    }

}