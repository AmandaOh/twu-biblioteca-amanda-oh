package com.twu.biblioteca.menus;

import com.twu.biblioteca.Router;
import org.junit.Test;

import static com.twu.biblioteca.menus.BookRepositoryMenu.GO_BACK;
import static com.twu.biblioteca.menus.BookRepositoryMenu.GO_BACK_COMMAND;
import static com.twu.biblioteca.menus.MainMenu.EXIT;
import static org.junit.Assert.*;

public class ReturnBookMenuTest {

    ReturnBookMenu menu = new ReturnBookMenu();
    Router router = new Router();

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

//    @Test
//    public void executeRouterRequestShouldReturnBookNameWhenReturnIsSuccessful() throws Exception {
//        BookRepository bookRepository = new BookRepository(new BookRepositoryMenu());
//        bookRepository.checkOutBook("1");
//        bookRepository = new BookRepository(menu);
//        Book book1 = bookRepository.getBook("1");
//        assertEquals(book1.getName(), menu.executeRouterRequest(router, "1"));
//    }



}