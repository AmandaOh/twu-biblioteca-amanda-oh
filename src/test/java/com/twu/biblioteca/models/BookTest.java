package com.twu.biblioteca.models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookTest {

        ArrayList<String> authors = new ArrayList<String>(Arrays.asList("Kathy Sierra", "Bert Bates"));
        Book javaBook = new Book("Head First Java", authors, 2001);

    @Test
    public void getsNameOfBook() {
        assertTrue(javaBook.getName().equals("Head First Java"));
    }


    @Test
    public void getsYearOfBook() {
        assertEquals(2001, javaBook.getYear());
    }

    @Test
    public void getsDirectorOfBook() {
        assertEquals(authors, javaBook.getAuthor());
    }

    @Test
    public void canBeFlaggedAsAvailableOrNot() {
        javaBook.setStatus(Book.Status.NOT_AVAILABLE);
        assertEquals(Book.Status.NOT_AVAILABLE, javaBook.getStatus());
        javaBook.setStatus(Book.Status.AVAILABLE);
        assertEquals(Book.Status.AVAILABLE, javaBook.getStatus());
    }


}