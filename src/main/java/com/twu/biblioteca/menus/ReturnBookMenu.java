package com.twu.biblioteca.menus;

import com.twu.biblioteca.Router;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Loanable;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.repositories.Library;

import java.util.List;

import static com.twu.biblioteca.Router.MAIN_MENU_INDEX;

public class ReturnBookMenu extends Menu {

    public static final String SUCCESSFUL_RETURN_MESSAGE = "\nThank you for returning ";
    public static final String FAIL_RETURN_MESSAGE = "\nThat is not a valid item to return.\n";

    private static final String RETURN_BOOK = "Return Book";

    private Library library;

    private String returnMessage = "";

    public ReturnBookMenu(Library library) {
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
            router.setState(MAIN_MENU_INDEX);
            returnMessage = "";
        } else {
            selectedOption = RETURN_BOOK;
            processReturn(input);
        }
        return selectedOption;
    }

    private void processReturn(String input) {
        Loanable item = library.returnItem(input);
        displayReturnMessage(item);
    }

    private void displayReturnMessage(Loanable item) {
        if (item == null) {
            returnMessage = FAIL_RETURN_MESSAGE;
        } else {
            returnMessage = SUCCESSFUL_RETURN_MESSAGE + item.getName() + "!\n";
        }
    }

    public String toString() {
        List<Loanable> borrowedBookList = library.filterBy(Loanable.Status.NOT_AVAILABLE, Book.class);
        StringBuilder bookTable = new StringBuilder();
        for (int i = 0; i < borrowedBookList.size(); i++) {
            Book book = (Book) borrowedBookList.get(i);
            bookTable.append(Integer.toString(i + 1) + "| ");
            bookTable.append(book.getName());
            bookTable.append(" ");
            bookTable.append(book.getAuthor());
            bookTable.append(" ");
            bookTable.append(book.getYear());
            bookTable.append("\n");

        }
        List<Loanable> borrowedMovieList = library.filterBy(Loanable.Status.NOT_AVAILABLE, Movie.class);
        StringBuilder movieTable = new StringBuilder();
        for (int i = borrowedBookList.size(); i < (borrowedBookList.size() + borrowedMovieList.size()); i++) {
            int index = i - borrowedBookList.size();
            Movie movie = (Movie) borrowedMovieList.get(index);
            movieTable.append(Integer.toString(i + 1) + "| ");
            movieTable.append(movie.getName());
            movieTable.append(" ");
            movieTable.append(movie.getDirector());
            movieTable.append(" ");
            movieTable.append(movie.getYear());
            movieTable.append("\n");
        }
        return returnMessage + "\nBORROWED BOOKS\n" + bookTable.toString() + "\nBORROWED MOVIES\n" + movieTable.toString() + "\nSELECT item number FOR returns.\n" + super.toString();
    }

}
