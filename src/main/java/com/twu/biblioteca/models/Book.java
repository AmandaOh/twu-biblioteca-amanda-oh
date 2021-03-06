package com.twu.biblioteca.models;

import java.util.ArrayList;

public class Book implements Loanable {

    private String name;
    private ArrayList<String> author;
    private int year;
    private Status status = Status.AVAILABLE;

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
