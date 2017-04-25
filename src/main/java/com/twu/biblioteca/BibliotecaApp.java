package com.twu.biblioteca;

import com.twu.biblioteca.models.Loanable;
import com.twu.biblioteca.repositories.Library;
import com.twu.biblioteca.utils.CommandLineInputHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.twu.biblioteca.menus.MainMenu.EXIT;

public class BibliotecaApp {

    public String getGreeting() {
        return "Hola! Welcome to Biblioteca.";
    }

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();

        System.out.println(app.getGreeting());

        Router router = initializeApp();

        Scanner scanner = new Scanner(System.in);
        String selectedOption = readSelectedOption(router, scanner);

        while (selectedOption != EXIT) {
            System.out.println(router.getPrintedResponse());
            selectedOption = readSelectedOption(router, scanner);
        }

    }

    private static Router initializeApp() {
        List<Loanable> staticBookData = InMemoryBooksDatabase.getBooks();
        List<Loanable> staticMovieData = InMemoryMoviesDatabase.getMovies();
        List<Loanable> allLoanableItems = new ArrayList<>(staticBookData);
        allLoanableItems.addAll(staticMovieData);
        Library library = new Library(allLoanableItems);
        Router router = new Router(library);
        System.out.println(router.getPrintedResponse());
        return router;
    }

    private static String readSelectedOption(Router router, Scanner scanner) {
        String userInput = scanner.next();
        String parsedInput = CommandLineInputHelper.parseInput(userInput);
        return router.getSelectedOption(parsedInput);
    }
}
