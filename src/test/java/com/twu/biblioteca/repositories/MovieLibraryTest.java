package com.twu.biblioteca.repositories;

import com.twu.biblioteca.models.Loanable;
import com.twu.biblioteca.models.Movie;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MovieLibraryTest {

    List<Loanable> movies = new ArrayList<>();

    private void loadMoviesForTestCase() {
        Movie movie1 = new Movie("The Godfather", 1972, "Francis Ford Coppola", 9);
        Movie movie2 = new Movie("Kill Bill", 2003, "Quentin Tarantino", 8);
        Movie movie3 = new Movie("Blood Diamond", 2003, "Edward Zwick", 8);
        Movie unratedMovie = new Movie("Nocturnal Animals", 2016, "Tom Ford");
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(unratedMovie);
    }

    @Test
    public void checkOutMovieReturnsMovieWhenSuccessful() throws Exception {
      loadMoviesForTestCase();
        MovieLibrary movieLibrary = new MovieLibrary(movies);
      assertEquals(movies.get(1), movieLibrary.checkOutMovie("1"));
    }



}