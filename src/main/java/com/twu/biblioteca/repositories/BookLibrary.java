package com.twu.biblioteca.repositories;

import com.twu.biblioteca.InMemoryBooksDatabase;
import com.twu.biblioteca.models.Book;

import java.util.List;
import java.util.stream.Collectors;

import static com.twu.biblioteca.models.Book.Status.AVAILABLE;
import static com.twu.biblioteca.models.Book.Status.NOT_AVAILABLE;

public class BookLibrary {

    //figure out how to stream available books from here
    private Book.Status bookStatus = AVAILABLE;
    private List<Book> books;

    public BookLibrary(List<Book> books) {
//        if (source instanceof BookLibraryMenu) {
//            bookStatus = AVAILABLE;
//            otherBookStatus = NOT_AVAILABLE;
//        }
//        else if (source instanceof ReturnBookMenu) {
//            bookStatus = NOT_AVAILABLE;
//            otherBookStatus = AVAILABLE;
//        }
        this.books = books;
    }

    private Book getBook(String selection) throws Exception {
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

    public Book checkOutBook(String bookNumber) {
        Book bookToCheckOut;
        try {
            bookToCheckOut = getBook(bookNumber);
            bookToCheckOut.setStatus(NOT_AVAILABLE);
        } catch (Exception e){
            bookToCheckOut = null;
        }
        return bookToCheckOut;
    }

    public Book returnBook(String bookNumber) {
        Book bookToCheckOut;
        try {
            bookToCheckOut = getBook(bookNumber);
            bookToCheckOut.setStatus(AVAILABLE);
        } catch (Exception e){
            bookToCheckOut = null;
        }
        return bookToCheckOut;
    }

    public String toString() {
        books = InMemoryBooksDatabase.getBooks().stream().filter(book -> book.getStatus() == bookStatus).collect(Collectors.toList());
        StringBuilder bookTable = new StringBuilder();
        for (int i = 0; i < books.size(); i++) {
            bookTable.append(Integer.toString(i + 1) + "| ");
            bookTable.append(books.get(i).getName());
            bookTable.append(" ");
            bookTable.append(books.get(i).getAuthor());
            bookTable.append(" ");
            bookTable.append(books.get(i).getYear());
//            bookTable.append(" ");
//            bookTable.append(books.get(i).getStatus());
            bookTable.append("\n");
        }
        return "LIST OF BOOKS\n" + bookTable.toString();
    }

    public List<Book> filterBooksByStatus(Book.Status status) {
        bookStatus = status;
        return books.stream().filter(book -> book.getStatus() == bookStatus).collect(Collectors.toList());
    }

}
