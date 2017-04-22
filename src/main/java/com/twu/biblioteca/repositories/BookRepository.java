package com.twu.biblioteca.repositories;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.InMemoryBooksDatabase;

import java.util.List;
import java.util.stream.Collectors;

import static com.twu.biblioteca.Book.Status.AVAILABLE;
import static com.twu.biblioteca.Book.Status.NOT_AVAILABLE;

public class BookRepository implements Repository {

    private List<Book> availableBooks =InMemoryBooksDatabase.getBooks().stream().filter(book -> book.getStatus() == AVAILABLE).collect(Collectors.toList());

    @Override
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

    public String checkOutBook(String bookNumber) {
        String bookName;
        try {
            Book bookToCheckOut = getBook(bookNumber);
            bookName = bookToCheckOut.getName();
            bookToCheckOut.setStatus(NOT_AVAILABLE);
        } catch (Exception e){
            bookName = null;
        }
        return bookName;
    }

    @Override
    public String toString() {
        availableBooks = InMemoryBooksDatabase.getBooks().stream().filter(book -> book.getStatus() == AVAILABLE).collect(Collectors.toList());
        StringBuilder bookTable = new StringBuilder();
        for (int i = 0; i < availableBooks.size(); i++) {
            bookTable.append(Integer.toString(i + 1) + "| ");
            bookTable.append(availableBooks.get(i).getName());
            bookTable.append(" ");
            bookTable.append(availableBooks.get(i).getAuthor());
            bookTable.append(" ");
            bookTable.append(availableBooks.get(i).getYear());
            bookTable.append(" ");
            bookTable.append(availableBooks.get(i).getStatus());
            bookTable.append("\n");
        }
        return "LIST OF BOOKS\n" + bookTable.toString();
    }



}
