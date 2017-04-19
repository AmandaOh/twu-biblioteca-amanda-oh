package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BookListTest {

        BookList bl = new BookList();

    @Test
    public void getBook1ReturnsHeadFirstJavaBook() throws Exception {
        assertEquals("Head First Java", bl.getBook("1").getName());
    }

    @Test
    public void getBook0ReturnsNullObject() throws Exception{
        assertNull(bl.getBook("0"));
    }

    @Test (expected = NumberFormatException.class)
    public void getBookRandomStringThrowsNumberFormatException() throws Exception {
        bl.getBook("asdsdf");
    }

}