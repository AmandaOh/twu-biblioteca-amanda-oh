package com.twu.biblioteca.repositories;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Loanable;
import com.twu.biblioteca.models.Movie;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LibraryTest {

    List<Loanable> loanableItems = new ArrayList<>();

    private void loadDataForTestCase() {
        Book book1 = new Book("Moneyball", new ArrayList<>(Arrays.asList("Michael Lewis")), 2003);
        Book book2 = new Book("The Great Gatsby", new ArrayList<>(Arrays.asList("F. Scott Fitzgerald")), 2004);
        Book book3 = new Book("Lean In", new ArrayList<>(Arrays.asList("Sheryl Sandberg")), 2013);
        Movie movie1 = new Movie("The Godfather", 1972, "Francis Ford Coppola", 9);
        Movie movie2 = new Movie("Kill Bill", 2003, "Quentin Tarantino", 8);
        Movie movie3 = new Movie("Blood Diamond", 2003, "Edward Zwick", 8);
        Movie unratedMovie = new Movie("Nocturnal Animals", 2016, "Tom Ford");
        loanableItems.add(book1);
        loanableItems.add(book2);
        loanableItems.add(book3);
        loanableItems.add(movie1);
        loanableItems.add(movie2);
        loanableItems.add(movie3);
        loanableItems.add(unratedMovie);
    }

    @Test
    public void checkOutBookReturnBookWhenSuccessful() throws Exception {
        loadDataForTestCase();
        Library library = new Library(loanableItems);
        assertEquals(loanableItems.get(0), library.checkOut("1", Book.class));
    }


    @Test
    public void checkOutBookReturnsNullIfNOTSuccessful() {
        loadDataForTestCase();
        Library library = new Library(loanableItems);
        assertNull(library.checkOut("23948", Book.class));
        assertNull(library.checkOut("sdrgkjn", Book.class));
    }

    @Test
    public void checkedOutBookStatusIsAvailableBeforeCheckOutAndNOTAvailableAfterCheckOut() throws Exception {
        loadDataForTestCase();
        Library library = new Library(loanableItems);
        Loanable book1 = loanableItems.get(0);
        assertEquals(Book.Status.AVAILABLE, book1.getStatus());
        library.checkOut("1", Book.class);
        assertEquals(Book.Status.NOT_AVAILABLE, book1.getStatus());
    }

    @Test
    public void returnsBookForSuccessfulReturnOfBook() throws Exception {
        loadDataForTestCase();
        Library library = new Library(loanableItems);
        Loanable book1 = loanableItems.get(0);
        library.checkOut("1",Book.class );
        assertEquals(book1, library.returnItem("1"));
    }

    @Test
    public void returnsNullForFailReturnOfBook() throws Exception {
        loadDataForTestCase();
        Library library = new Library(loanableItems);
        library.checkOut("1", Book.class);
        assertNull(library.returnItem("234435"));
    }

    @Test
    public void checkOutMovieReturnsMovieWhenSuccessful() throws Exception {
        loadDataForTestCase();
        Library library = new Library(loanableItems);
        assertEquals(loanableItems.get(3), library.checkOut("1", Movie.class));
    }

    @Test
    public void returnsMovieForSuccessfulReturnOfMovie() throws Exception {
        loadDataForTestCase();;
        Library library = new Library(loanableItems);
        Loanable movie1 = loanableItems.get(3);
        library.checkOut("1", Movie.class);
        assertEquals(movie1, library.returnItem("1"));
    }

    @Test
    public void returnsNullForFailReturnOfMovie() throws Exception {
        loadDataForTestCase();
        Library library = new Library(loanableItems);
        library.checkOut("1", Movie.class);
        assertNull(library.returnItem("r234435"));
    }

}