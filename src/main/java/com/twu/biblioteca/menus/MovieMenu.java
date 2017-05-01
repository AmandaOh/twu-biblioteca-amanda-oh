package com.twu.biblioteca.menus;

import com.twu.biblioteca.Router;
import com.twu.biblioteca.models.Loanable;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.repositories.Library;

import java.util.List;

import static com.twu.biblioteca.menus.BookLibraryMenu.FAIL_CHECK_OUT_MESSAGE;
import static com.twu.biblioteca.menus.BookLibraryMenu.SUCCESSFUL_CHECK_OUT_MESSAGE;
import static com.twu.biblioteca.models.Loanable.Status.AVAILABLE;

public class MovieMenu extends Menu {

    private static final String CHECK_OUT_MOVIE = "Check Out";
    private Library library;

    private String movieReturnMessage = "";

    public MovieMenu(Library library) {
        addOption(GO_BACK_COMMAND, GO_BACK);
        addOption(EXIT_COMMAND, EXIT);
        this.library = library;
    }

    @Override
    public String executeRouterRequest(Router router, String input) {
        String selectedOption = getOption(input);
        if (selectedOption.equals(EXIT)) {
            return EXIT;
        } else if (selectedOption == GO_BACK) {
            router.setState(Router.MAIN_MENU_INDEX);
        } else {
            selectedOption = CHECK_OUT_MOVIE;
            processCheckOut(input);
        }
        return selectedOption;
    }

    private void processCheckOut(String input) {
        Loanable checkedOutMovie = library.checkOut(input, Movie.class);
        displayCheckOutMessage(checkedOutMovie);
    }

    private void displayCheckOutMessage(Loanable checkedOutMovie) {
        Movie movie = (Movie) checkedOutMovie;
        if (movie == null) {
            movieReturnMessage = FAIL_CHECK_OUT_MESSAGE;
        } else {
            movieReturnMessage = "You have checked out " + movie.getName() + ". " + SUCCESSFUL_CHECK_OUT_MESSAGE;
        }
    }

    public String toString() {
        List<Loanable> movieList = library.filterBy(AVAILABLE, Movie.class);
        StringBuilder table = new StringBuilder();
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = (Movie) movieList.get(i);
            table.append(Integer.toString(i + 1) + "| ");
            table.append(movie.getName());
            table.append(" ");
            table.append(movie.getDirector());
            table.append(" ");
            table.append(movie.getYear());
            table.append(" ");
            table.append(movie.getRating());
            table.append("\n");
        }
        return  "\n" + movieReturnMessage + "\nLIST OF MOVIES\n" + table.toString() + "\nSELECT movie number FOR Check Out.\n" + super.toString() + "Please key your selection here: ";
    }
}
