package com.twu.biblioteca.models;

import org.junit.Test;

import static com.twu.biblioteca.models.Movie.UNRATED;
import static org.junit.Assert.*;

public class MovieTest {

    Movie movie = new Movie("La La Land", 2016, "Damien Chazelle", 10);

    @Test
    public void getNameReturnsNameOfMovie() {
        assertEquals("La La Land", movie.getName());
    }

    @Test
    public void getYearReturnsYearOfMovie() {
        assertEquals(2016, movie.getYear());
    }

    @Test
    public void getDirectorReturnsDirectorName() {
        assertEquals("Damien Chazelle", movie.getDirector());
    }

    @Test
    public void getRatingReturnsRatingBetween1to10() {
        assertEquals(10, movie.getRating());
    }

    @Test
    public void movieIsCreatedWithUnratedRatingIfNoRatingIsProvided() {
        Movie unratedMovie = new Movie("The Fate of the Furious", 2017, "F. Gary Gray");
        assertEquals(UNRATED, unratedMovie.getRating());
    }
}