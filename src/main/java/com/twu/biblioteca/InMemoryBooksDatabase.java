package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InMemoryBooksDatabase {

    private static List<Book> books;

    public static synchronized List<Book> getBooks() {
        return books == null ? books = InMemoryBooksDatabase.initialize() : books;
    }

    private static List<Book> initialize() {
        books = new ArrayList<Book>();
        Book book1 = new Book("Head First Java", new ArrayList<String>(Arrays.asList("Kathy Sierra", "Bert Bates")), 2001);
        books.add(book1);
        Book book2 = new Book("Moby Dick", new ArrayList<String>(Arrays.asList("Herman Melville")), 1851);
        books.add(book2);
        Book book3 = new Book ("The Great Gatsby", new ArrayList<String>(Arrays.asList("F. Scott Fitzgerald")), 2004);
        books.add(book3);
        Book book4 = new Book ("Pride and Prejudice", new ArrayList<String>(Arrays.asList("Jane Austen")), 2002);
        books.add(book4);
        return books;
    }

}
