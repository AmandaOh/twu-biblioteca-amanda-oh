package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class BookRepository {

    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Book> checkedOutBooks = new ArrayList<Book>();

    public BookRepository() {
        Book book1 = new Book("Head First Java", new ArrayList<String>(Arrays.asList("Kathy Sierra", "Bert Bates")), 2001);
        books.add(book1);
        Book book2 = new Book("Moby Dick", new ArrayList<String>(Arrays.asList("Herman Melville")), 1851);
        books.add(book2);
        Book book3 = new Book ("The Great Gatsby", new ArrayList<String>(Arrays.asList("F. Scott Fitzgerald")), 2004);
        books.add(book3);
        Book book4 = new Book ("Pride and Prejudice", new ArrayList<String>(Arrays.asList("Jane Austen")), 2002);
        books.add(book4);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public Book getBook(String selection) throws Exception {
        int index;
        Book book;
        try {
            index = Integer.parseInt(selection) - 1;
            book = books.get(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            book = null;
        } catch (NumberFormatException e) {
            throw e;
        }
        return book;
    }

    public String toString() {
        StringBuilder bookTable = new StringBuilder();
        for (int i = 0; i < books.size(); i++) {
            bookTable.append(Integer.toString(i + 1) + "| ");
            bookTable.append(books.get(i).getName());
            bookTable.append(" ");
            bookTable.append(books.get(i).getAuthor());
            bookTable.append(" ");
            bookTable.append(books.get(i).getYear());
            bookTable.append("\n");
        }
        return "LIST OF BOOKS\n" + bookTable.toString();
    }

    public String checkOutBook(String bookNumber) {
        String bookName;
        try {
            Book bookToCheckOut = getBook(bookNumber);
            books.remove(bookToCheckOut);
            checkedOutBooks.add(bookToCheckOut);
            bookName = bookToCheckOut.getName();
        } catch (Exception e){
            bookName = null;
        }
        return bookName;
    }

    public String returnBook(String bookNumber) {
        String bookName;
        try {
            Book bookToReturn = getBook(bookNumber);
            checkedOutBooks.remove(bookToReturn);
            books.add(bookToReturn);
            bookName = bookToReturn.getName();
        } catch (Exception e) {
            bookName = null;
        }
        return bookName;
    }
}
