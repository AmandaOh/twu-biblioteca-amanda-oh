package com.twu.biblioteca.repositories;

import com.twu.biblioteca.Book;

interface Repository {

    Book getBook(String selection) throws Exception;

    String toString();
}
