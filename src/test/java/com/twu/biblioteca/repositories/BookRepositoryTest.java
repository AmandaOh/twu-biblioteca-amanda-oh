package com.twu.biblioteca.repositories;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.repositories.BookRepository;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class BookRepositoryTest {

    BookRepository bl = new BookRepository();

    //Test to run on its own
    @Test
    public void getBook1ReturnsHeadFirstJavaBook() throws Exception {
        assertEquals("Head First Java", bl.getBook("1").getName());
    }

    @Test
    public void getBook0ReturnsNullObject() throws Exception {
        assertNull(bl.getBook("0"));
    }

    @Test(expected = NumberFormatException.class)
    public void getBookRandomStringThrowsNumberFormatException() throws Exception {
        bl.getBook("asdsdf");
    }

    @Test
    public void checkOutBookReturnsBookNameWhenSuccessful() throws Exception {
        Book book1 = bl.getBook("1");
        assertEquals(book1.getName(), bl.checkOutBook("1"));
    }

    @Test
    public void checkOutBookReturnsNullIfNOTSuccessful() {
        assertNull(bl.checkOutBook("23948"));
        assertNull(bl.checkOutBook("sdrgkjn"));
    }

    @Test
    public void checkedOutBookStatusIsAvailableAfterCheckOut() throws Exception {
        Book book1 = bl.getBook("1");
        bl.checkOutBook("1");
        assertTrue(book1.getStatus() == Book.Status.NOT_AVAILABLE);
    }
}