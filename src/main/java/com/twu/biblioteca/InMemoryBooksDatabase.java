package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Loanable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InMemoryBooksDatabase {

    private static List<Loanable> books;

    public static synchronized List<Loanable> getBooks() {
        return books == null ? books = InMemoryBooksDatabase.initialize() : books;
    }

    private static List<Loanable> initialize() {
        books = new ArrayList<>();
        Book book1 = new Book("Head First Java", new ArrayList<>(Arrays.asList("Kathy Sierra", "Bert Bates")), 2001);
        Book book2 = new Book("Moby Dick", new ArrayList<>(Arrays.asList("Herman Melville")), 1851);
        Book book3 = new Book ("The Great Gatsby", new ArrayList<>(Arrays.asList("F. Scott Fitzgerald")), 2004);
        Book book4 = new Book ("Pride and Prejudice", new ArrayList<>(Arrays.asList("Jane Austen")), 2002);
        Book book5 = new Book ("Gone with the Wind", new ArrayList<>(Arrays.asList("Margaret Mitchell")), 1999);
        Book book6 = new Book ("A Tale of Two Cities", new ArrayList<>(Arrays.asList("Charles Dickens", "Richard Maxwell")), 2003);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        return books;
    }

}
