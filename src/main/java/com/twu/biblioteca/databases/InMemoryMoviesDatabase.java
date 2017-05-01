package com.twu.biblioteca.databases;

import com.twu.biblioteca.models.Loanable;
import com.twu.biblioteca.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMoviesDatabase {

    private static List<Loanable> movies;

    public static synchronized List<Loanable> getMovies() {
        return movies == null? InMemoryMoviesDatabase.initialize() : movies;
    }

    private static List<Loanable> initialize() {
        movies = new ArrayList<>();
        Movie movie1 = new Movie("La La Land", 2016, "Damien Chazelle", 10);
        Movie movie2 = new Movie("The Fate of the Furious", 2017, "F. Gary Gray");
        Movie movie3 = new Movie("Toy Story", 1996, "John Lasseter", 9);
        Movie movie4 = new Movie("Armageddon", 1998, "Michael Bay", 8);
        Movie movie5 = new Movie("Twilight", 2008, "Catherine Hardwicke", 1);
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);
        return movies;
    }

}
