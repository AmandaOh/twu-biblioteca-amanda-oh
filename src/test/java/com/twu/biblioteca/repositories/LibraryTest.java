package com.twu.biblioteca.repositories;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Loanable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LibraryTest {

    List<Loanable> books = new ArrayList<>();

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
        Library library = new Library(books);
        assertEquals(books.get(0), library.checkOut("1", Book.class));
    }


    @Test
    public void checkOutBookReturnsNullIfNOTSuccessful() {
        loadBooksForTestCase();
        Library library = new Library(books);
        assertNull(library.checkOut("23948", Book.class));
        assertNull(library.checkOut("sdrgkjn", Book.class));
    }

    @Test
    public void checkedOutBookStatusIsAvailableBeforeCheckOutAndNOTAvailableAfterCheckOut() throws Exception {
        loadBooksForTestCase();
        Library library = new Library(books);
        Loanable book1 = books.get(0);
        assertEquals(Book.Status.AVAILABLE, book1.getStatus());
        library.checkOut("1", Book.class);
        assertEquals(Book.Status.NOT_AVAILABLE, book1.getStatus());
    }

    @Test
    public void returnsBookForSuccessfulReturnOfBook() throws Exception {
        loadBooksForTestCase();
        Library library = new Library(books);
        Loanable book1 = books.get(0);
        library.checkOut("1",Book.class );
        assertEquals(book1, library.returnItem("1"));
    }

    @Test
    public void returnsNullForFailReturnOfBook() throws Exception {
        loadBooksForTestCase();
        Library library = new Library(books);
        library.checkOut("1", Book.class);
        assertNull(library.returnItem("234435"));
    }

}