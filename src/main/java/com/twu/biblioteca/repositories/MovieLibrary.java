package com.twu.biblioteca.repositories;

import com.twu.biblioteca.InMemoryMoviesDatabase;
import com.twu.biblioteca.models.Movie;

import java.util.List;
import java.util.stream.Collectors;

import static com.twu.biblioteca.models.Loanable.Status.AVAILABLE;
import static com.twu.biblioteca.models.Loanable.Status.NOT_AVAILABLE;

public class MovieLibrary {

    private List<Movie> movies = InMemoryMoviesDatabase.getMovies().stream().filter(movie -> movie.getStatus() == AVAILABLE).collect(Collectors.toList());;

    public Movie getMovie(String selection) throws Exception {
        int index;
        Movie book;
        try {
            index = Integer.parseInt(selection) - 1;
            book = movies.get(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            book = null;
        } catch (NumberFormatException e) {
            throw e;
        }
        return book;
    }

    public String checkOutMovie(String movieNumber) {
        String movieName;
        try {
            Movie movieToCheckOut = getMovie(movieNumber);
            movieName = movieToCheckOut.getName();
            movieToCheckOut.setStatus(NOT_AVAILABLE);
        } catch (Exception e) {
            movieName = null;
        }
        return movieName;
    }

    public String toString() {
        movies = InMemoryMoviesDatabase.getMovies().stream().filter(movie -> movie.getStatus() == AVAILABLE).collect(Collectors.toList());
        StringBuilder moviesTable = new StringBuilder();
        for (int i = 0; i < movies.size(); i++) {
            moviesTable.append(Integer.toString(i + 1) + "|");
            moviesTable.append(movies.get(i).getName());
            moviesTable.append(" ");
            moviesTable.append(movies.get(i).getYear());
            moviesTable.append(" ");
            moviesTable.append(movies.get(i).getDirector());
            moviesTable.append(" ");
            int movieRating = movies.get(i).getRating();
            if (movieRating == 0) {
                moviesTable.append("Unrated");
            } else {
                moviesTable.append(movieRating);
            }
            moviesTable.append("\n");
        }
        return "LIST OF MOVIES\n" + moviesTable.toString();
    }

}
