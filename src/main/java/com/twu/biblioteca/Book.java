package com.twu.biblioteca;

import java.util.ArrayList;

public class Book {

    private String name;
    private ArrayList<String> author;
    private int year;

    public Book (String name, ArrayList<String> author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
