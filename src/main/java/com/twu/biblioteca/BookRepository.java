package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BookRepository {

    public static final String SUCCESSFUL_CHECK_OUT = "You have successfully checked out book";
    public static final String FAIL_CHECK_OUT_MESSAGE = "Unsuccessful checkout. Book Is Not Available.";
    private ArrayList<Book> availableBooks;

    public BookRepository() {
        availableBooks = new ArrayList<Book>();
        Book book1 = new Book("Head First Java", new ArrayList<String>(Arrays.asList("Kathy Sierra", "Bert Bates")), 2001);
        availableBooks.add(book1);
        Book book2 = new Book("Moby Dick", new ArrayList<String>(Arrays.asList("Herman Melville")), 1851);
        availableBooks.add(book2);
        Book book3 = new Book ("The Great Gatsby", new ArrayList<String>(Arrays.asList("F. Scott Fitzgerald")), 2004);
        availableBooks.add(book3);
        Book book4 = new Book ("Pride and Prejudice", new ArrayList<String>(Arrays.asList("Jane Austen")), 2002);
        availableBooks.add(book4);
    }

    public ArrayList<Book> getAllBooks() {
        return availableBooks;
    }

    public Book getBook(String selection) throws Exception {
        int index;
        Book book;
        try {
            index = Integer.parseInt(selection) - 1;
            book = availableBooks.get(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            book = null;
        } catch (NumberFormatException e) {
            throw e;
        }
        return book;
    }

    public String toString() {
        StringBuilder bookTable = new StringBuilder();
        for (int i = 0; i < availableBooks.size(); i++) {
            bookTable.append(Integer.toString(i + 1) + "| ");
            bookTable.append(availableBooks.get(i).getName());
            bookTable.append(" ");
            bookTable.append(availableBooks.get(i).getAuthor());
            bookTable.append(" ");
            bookTable.append(availableBooks.get(i).getYear());
            bookTable.append("\n");
        }
        return "LIST OF BOOKS\n" + bookTable.toString();
    }

    public String checkOutBook(String bookNumber) {
        String bookName;
        try {
            Book bookToCheckOut = getBook(bookNumber);
            availableBooks.remove(bookToCheckOut);
            bookName = bookToCheckOut.getName();
        } catch (Exception e){
            bookName = null;
        }
        return bookName;
    }
}
