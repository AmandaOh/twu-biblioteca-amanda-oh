package com.twu.biblioteca.repositories;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.InMemoryBooksDatabase;

import java.util.List;
import java.util.stream.Collectors;

import static com.twu.biblioteca.Book.Status.AVAILABLE;
import static com.twu.biblioteca.Book.Status.NOT_AVAILABLE;

public class CheckedOutBooksRepository implements Repository {

    private List<Book> checkedOutBooks = InMemoryBooksDatabase.getBooks().stream().filter(book -> book.getStatus() == NOT_AVAILABLE).collect(Collectors.toList());

    @Override
    public Book getBook(String selection) throws Exception {
        int index;
        Book book;
        try {
            index = Integer.parseInt(selection) - 1;
            book = checkedOutBooks.get(index);
        } catch (IndexOutOfBoundsException e) {
            book = null;
        } catch (NumberFormatException e) {
            throw e;
        }
        return book;
    }

    public String returnBook(String bookNumber) {
        String bookName;
        try {
            Book bookToReturn = getBook(bookNumber);
            bookName = bookToReturn.getName();
            bookToReturn.setStatus(AVAILABLE);
        } catch (Exception e) {
            bookName = null;
        }
        return bookName;
    }


    @Override
    public String toString() {
        checkedOutBooks = InMemoryBooksDatabase.getBooks().stream().filter(book -> book.getStatus() == NOT_AVAILABLE).collect(Collectors.toList());
        StringBuilder bookTable = new StringBuilder();
        for (int i = 0; i < checkedOutBooks.size(); i++) {
            bookTable.append(Integer.toString(i + 1) + "| ");
            bookTable.append(checkedOutBooks.get(i).getName());
            bookTable.append(" ");
            bookTable.append(checkedOutBooks.get(i).getAuthor());
            bookTable.append(" ");
            bookTable.append(checkedOutBooks.get(i).getYear());
            bookTable.append(" ");
            bookTable.append(checkedOutBooks.get(i).getStatus());
            bookTable.append("\n");
        }
        return "BORROWED BOOKS\n" + bookTable.toString();
    }


}
