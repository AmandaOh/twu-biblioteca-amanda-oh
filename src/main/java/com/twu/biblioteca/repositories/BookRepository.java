package com.twu.biblioteca.repositories;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.InMemoryBooksDatabase;
import com.twu.biblioteca.menus.BookRepositoryMenu;
import com.twu.biblioteca.menus.Menu;
import com.twu.biblioteca.menus.ReturnBookMenu;

import java.util.List;
import java.util.stream.Collectors;

import static com.twu.biblioteca.Book.Status.AVAILABLE;
import static com.twu.biblioteca.Book.Status.NOT_AVAILABLE;

public class BookRepository {

    private Book.Status bookStatus;
    private Book.Status otherBookStatus;
    private List<Book> books =InMemoryBooksDatabase.getBooks().stream().filter(book -> book.getStatus() == bookStatus).collect(Collectors.toList());

    public BookRepository(Menu source) {
        if (source instanceof BookRepositoryMenu) {
            bookStatus = AVAILABLE;
            otherBookStatus = NOT_AVAILABLE;
        }
        else if (source instanceof ReturnBookMenu) {
            bookStatus = NOT_AVAILABLE;
            otherBookStatus = AVAILABLE;
        }
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

    public String checkOutBook(String bookNumber) {
        String bookName;
        try {
            Book bookToCheckOut = getBook(bookNumber);
            bookName = bookToCheckOut.getName();
            bookToCheckOut.setStatus(otherBookStatus);
        } catch (Exception e){
            bookName = null;
        }
        return bookName;
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



}
