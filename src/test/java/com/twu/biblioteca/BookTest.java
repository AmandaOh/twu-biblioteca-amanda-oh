package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void getsNameOfBook() {
        ArrayList<String> authors = new ArrayList<String>(Arrays.asList("Kathy Sierra", "Bert Bates"));
        Book javaBook = new Book("Head First Java", authors, 2001);
        assertTrue(javaBook.getName().equals("Head First Java"));
    }


}