package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private BookList bookList;

    public BibliotecaApp () {
        bookList = new BookList();
    }

    public String getGreeting() {
        return "Hi there, welcome to our library.";
    }

    public String getAllBooks() {
        return bookList.toString();
    }

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        System.out.println(app.getGreeting());
        System.out.println("These are our list of books:");
        System.out.println(app.getAllBooks());

        Scanner scanner = new Scanner(System.in);
        String letter = scanner.next();
        System.out.println(letter);
    }
}
