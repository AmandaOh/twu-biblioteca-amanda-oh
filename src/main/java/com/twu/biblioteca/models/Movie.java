package com.twu.biblioteca.models;

import static com.twu.biblioteca.models.Loanable.Status.AVAILABLE;

public class Movie implements Loanable{

    public static final int UNRATED = 0;

    private String name;
    private int year;
    private String director;
    private int rating;
    private Book.Status status;

    public Movie(String name, int year, String director) {
        this.name = name;
        this.year = year;
        this.director = director;
        rating = UNRATED;
        status = AVAILABLE;
    }

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        try {
            this.rating = setRating(rating);
        } catch (Exception e) {
            System.out.println(e);
        }
        status = AVAILABLE;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    //only ranges from 1 - 10
    public int getRating() {
        return rating;
    }

    private int setRating(int rating) throws Exception {
        int ratingMinValue = 1;
        int ratingMaxValue = 10;
        if (rating >= ratingMinValue && rating <= ratingMaxValue) {
            return rating;
        } else {
            throw new Exception("Rating should be from 1- 10");
        }
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
