package com.twu.biblioteca.repositories;

import com.twu.biblioteca.models.Book;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BookLibraryTest {

    List<Book> books = new ArrayList<>();

    private void loadBooksForTestCase() {
        Book book1 = new Book("Moneyball", new ArrayList<>(Arrays.asList("Michael Lewis")), 2003);
        Book book2 = new Book("The Great Gatsby", new ArrayList<>(Arrays.asList("F. Scott Fitzgerald")), 2004);
        Book book3 = new Book("Lean In", new ArrayList<>(Arrays.asList("Sheryl Sandberg")), 2013);
        books.add(book1);
        books.add(book2);
        books.add(book3);
    }

    @Test
    public void checkOutBookReturnBookWhenSuccessful() throws Exception {
        loadBooksForTestCase();
        BookLibrary library = new BookLibrary(books);
        assertEquals(books.get(0), library.checkOutBook("1"));
    }


    @Test
    public void checkOutBookReturnsNullIfNOTSuccessful() {
        loadBooksForTestCase();
        BookLibrary library = new BookLibrary(books);
        assertNull(library.checkOutBook("23948"));
        assertNull(library.checkOutBook("sdrgkjn"));
    }

    @Test
    public void checkedOutBookStatusIsAvailableBeforeCheckOutAndNOTAvailableAfterCheckOut() throws Exception {
        loadBooksForTestCase();
        BookLibrary library = new BookLibrary(books);
        Book book1 = books.get(0);
        assertEquals(Book.Status.AVAILABLE, book1.getStatus());
        library.checkOutBook("1");
        assertEquals(Book.Status.NOT_AVAILABLE, book1.getStatus());
    }

    @Test
    public void returnsBookForSuccessfulReturnOfBook() throws Exception {
        loadBooksForTestCase();
        BookLibrary library = new BookLibrary(books);
        Book book1 = books.get(0);
        library.checkOutBook("1");
        assertEquals(book1, library.returnBook("1"));
    }

    @Test
    public void returnsNullForFailReturnOfBook() throws Exception {
        loadBooksForTestCase();
        BookLibrary library = new BookLibrary(books);
        library.checkOutBook("1");
        assertNull(library.returnBook("234435"));
    }

}