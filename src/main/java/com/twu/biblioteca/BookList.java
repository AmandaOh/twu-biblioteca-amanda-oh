package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class BookList {

    private ArrayList<Book> bookList;

    public BookList() {
        bookList = new ArrayList<Book>();
        Book book1 = new Book("Head First Java", new ArrayList<String>(Arrays.asList("Kathy Sierra", "Bert Bates")), 2001);
        bookList.add(book1);
        Book book2 = new Book("Moby Dick", new ArrayList<String>(Arrays.asList("Herman Melville")), 1851);
        bookList.add(book2);
        Book book3 = new Book ("The Great Gatsby", new ArrayList<String>(Arrays.asList("F. Scott Fitzgerald")), 2004);
        bookList.add(book3);
        Book book4 = new Book ("Pride and Prejudice", new ArrayList<String>(Arrays.asList("Jane Austen")), 2002);
        bookList.add(book4);
    }

    public Book getBook(String selection) throws Exception {
        int index;
        Book book;
        try {
            index = Integer.parseInt(selection) - 1;
            book = bookList.get(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            book = null;
        } catch (NumberFormatException e) {
            throw e;
        }
        return book;
    }

    public String toString() {
        StringBuilder bookTable = new StringBuilder();
        for (int i = 0; i < bookList.size(); i++) {
            bookTable.append(Integer.toString(i + 1) + "| ");
            bookTable.append(bookList.get(i).getName());
            bookTable.append(" ");
            bookTable.append(bookList.get(i).getAuthor());
            bookTable.append(" ");
            bookTable.append(bookList.get(i).getYear());
            bookTable.append("\n");
        }
        return bookTable.toString();
    }

}
