package com.twu.biblioteca.menus;

import com.twu.biblioteca.Router;
import com.twu.biblioteca.repositories.MovieRepository;

import static com.twu.biblioteca.menus.BookLibraryMenu.FAIL_CHECK_OUT_MESSAGE;
import static com.twu.biblioteca.menus.BookLibraryMenu.SUCCESSFUL_CHECK_OUT_MESSAGE;

public class MovieMenu extends Menu {

    private MovieRepository moviesRepository = new MovieRepository();
    private String movieReturnMessage = "";

    public MovieMenu() {
        addOption(GO_BACK_COMMAND, GO_BACK);
        addOption(EXIT_COMMAND, EXIT);
    }

    //Configure Back and Exit commands;
    @Override
    public String executeRouterRequest(Router router, String input) {
        String selectedOption = getOption(input);
        if (selectedOption == NO_SUCH_OPTION) {
            selectedOption = moviesRepository.checkOutMovie(input);
            displayCheckOutMessage(selectedOption);
            } else if (selectedOption == GO_BACK) {
            router.setState(Router.MAIN_MENU_INDEX);
        }

        return null;
    }

    private void displayCheckOutMessage(String selectedOption) {
        if (selectedOption == null) {
            movieReturnMessage = FAIL_CHECK_OUT_MESSAGE;
        } else {
            movieReturnMessage = "You have checked out " + selectedOption + ". " + SUCCESSFUL_CHECK_OUT_MESSAGE;
        }
    }

    public String toString() {
        String moviesList = moviesRepository.toString();
        return "\n" + movieReturnMessage + "\n" + moviesList + "\n" + super.toString();
    }
}
