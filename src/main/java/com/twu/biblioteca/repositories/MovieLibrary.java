package com.twu.biblioteca.repositories;

import com.twu.biblioteca.InMemoryMoviesDatabase;
import com.twu.biblioteca.models.Loanable;
import com.twu.biblioteca.models.Movie;

import java.util.List;
import java.util.stream.Collectors;

import static com.twu.biblioteca.models.Loanable.Status.AVAILABLE;
import static com.twu.biblioteca.models.Loanable.Status.NOT_AVAILABLE;

public class MovieLibrary {

    private Loanable.Status moviesStatus = AVAILABLE;
    private List<Loanable> movies = InMemoryMoviesDatabase.getMovies().stream().filter(movie -> movie.getStatus() == AVAILABLE).collect(Collectors.toList());;

    public MovieLibrary(List<Loanable> movies) {
        this.movies = movies;
    }

    private Loanable getMovie(String selection) throws Exception {
        int index;
        Loanable movie;
        try {
            index = Integer.parseInt(selection) - 1;
            movie = movies.get(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            movie = null;
        } catch (NumberFormatException e) {
            throw e;
        }
        return movie;
    }

    public Loanable checkOutMovie(String movieNumber) {
        Loanable movie;
        try {
            movie = getMovie(movieNumber);
            movie.setStatus(NOT_AVAILABLE);
        } catch (Exception e) {
            movie = null;
        }
        return movie;
    }

    public String toString() {
        movies = InMemoryMoviesDatabase.getMovies().stream().filter(movie -> movie.getStatus() == AVAILABLE).collect(Collectors.toList());
        StringBuilder moviesTable = new StringBuilder();
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = (Movie) movies.get(i);
            moviesTable.append(Integer.toString(i + 1) + "|");
            moviesTable.append(movie.getName());
            moviesTable.append(" ");
            moviesTable.append(movie.getYear());
            moviesTable.append(" ");
            moviesTable.append(movie.getDirector());
            moviesTable.append(" ");
            int movieRating = movie.getRating();
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
