package com.twu.biblioteca.repositories;

import com.twu.biblioteca.menus.BookRepositoryMenu;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookRepositoryTest {

    BookRepository bl = new BookRepository(new BookRepositoryMenu());

    //Test to run on its own
    //    @Test
    //    public void getBook1ReturnsHeadFirstJavaBook() throws Exception {
    //        BookRepository bl = new BookRepository();
    //        assertEquals("Head First Java", bl.getBook("1").getName());
    //    }

    @Test
    public void getBook0ReturnsNullObject() throws Exception {
        assertNull(bl.getBook("0"));
    }

    @Test(expected = NumberFormatException.class)
    public void getBookRandomStringThrowsNumberFormatException() throws Exception {
        bl.getBook("asdsdf");
    }

    //    @Test
    //    public void checkOutBookReturnsBookNameWhenSuccessful() throws Exception {
    //        Book book1 = bl.getBook("1");
    //        assertEquals(book1.getName(), bl.checkOutBook("1"));
    //    }

    @Test
    public void checkOutBookReturnsNullIfNOTSuccessful() {
        assertNull(bl.checkOutBook("23948"));
        assertNull(bl.checkOutBook("sdrgkjn"));
    }

    //    @Test
    //    public void checkedOutBookStatusIsAvailableAfterCheckOut() throws Exception {
    //        Book book1 = bl.getBook("1");
    //        bl.checkOutBook("1");
    //        assertTrue(book1.getStatus() == Book.Status.NOT_AVAILABLE);
    //    }

    //    @Test
    //    public void returnsBookNameForSuccessfulReturnOfBook() throws Exception {
    //        bookRepository.checkOutBook("1");
    //        Book book1 = bookRepository.getBook("1");
    //        assertEquals(book1.getName(), bookRepository.checkOutBook("1"));
    //    }

    @Test
    public void returnsNullForFailReturnOfBook() throws Exception {
        assertNull(bl.checkOutBook("234435"));
    }
}