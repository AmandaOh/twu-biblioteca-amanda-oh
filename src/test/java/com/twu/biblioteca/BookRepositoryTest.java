package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.twu.biblioteca.BookRepository.FAIL_CHECK_OUT_MESSAGE;
import static com.twu.biblioteca.BookRepository.SUCCESSFUL_CHECK_OUT;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class BookRepositoryTest {

    BookRepository bl = new BookRepository();

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

    @Test
    public void checkOutBookReturnsBookNameWhenSuccessful() {
        Book book1;
        try {
            book1 = bl.getBook("1");
        } catch (Exception e) {
            book1 = null;
        }
        assertEquals(book1.getName(), bl.checkOutBook("1"));
    }

    @Test
    public void checkOutBookReturnsNullIfNOTSuccessful(){
        assertNull(bl.checkOutBook("23948"));
        assertNull(bl.checkOutBook("sdrgkjn"));
    }

    @Test
    public void bookListDoesNotContainBookAfterItIsCheckedOut() {
        Book book1;
        try {
            book1 = bl.getBook("1");
        } catch (Exception e) {
            book1 = null;
        }
        bl.checkOutBook("1");
        assertThat(bl.getAllBooks(), not(hasItem(book1)));
    }


}