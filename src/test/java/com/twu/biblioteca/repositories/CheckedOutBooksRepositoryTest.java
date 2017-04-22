package com.twu.biblioteca.repositories;

import com.twu.biblioteca.Book;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckedOutBooksRepositoryTest {

    BookRepository bookRepository = new BookRepository();
    CheckedOutBooksRepository checkedOutBooks = new CheckedOutBooksRepository();

    @Test
    public void returnsBookNameForSuccessfulReturnOfBook() throws Exception {
        bookRepository.checkOutBook("1");
        Book book1 = checkedOutBooks.getBook("1");
        assertEquals(book1.getName(), checkedOutBooks.returnBook("1"));
    }

    @Test public void returnsNullForFailReturnOfBook() throws Exception {
        assertNull(checkedOutBooks.returnBook("234435"));
    }


}