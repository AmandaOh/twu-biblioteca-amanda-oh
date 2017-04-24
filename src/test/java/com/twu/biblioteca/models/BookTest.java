package com.twu.biblioteca.models;

import com.twu.biblioteca.models.Book;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BookTest {

        ArrayList<String> authors = new ArrayList<String>(Arrays.asList("Kathy Sierra", "Bert Bates"));
        Book javaBook = new Book("Head First Java", authors, 2001);

    @Test
    public void getsNameOfBook() {
        assertTrue(javaBook.getName().equals("Head First Java"));
    }


    @Test
    public void canBeFlaggedAsAvailableOrNot() {
        javaBook.setStatus(Book.Status.NOT_AVAILABLE);
        assertEquals(Book.Status.NOT_AVAILABLE, javaBook.getStatus());
        javaBook.setStatus(Book.Status.AVAILABLE);
        assertEquals(Book.Status.AVAILABLE, javaBook.getStatus());
    }
}