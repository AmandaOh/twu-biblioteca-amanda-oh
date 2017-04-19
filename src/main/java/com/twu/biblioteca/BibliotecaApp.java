package com.twu.biblioteca;

import com.twu.biblioteca.utils.CommandLineInputHelper;

import java.util.Scanner;

import static com.twu.biblioteca.MainMenu.BOOK_LIST;
import static com.twu.biblioteca.MainMenu.EXIT;

public class BibliotecaApp {

    public static final int MAIN_PAGE = 0;
    public static final int BOOK_REPO_PAGE = 1;

    public String getGreeting() {
        return "Hi there, welcome to our library.";
    }

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        BookList booklist = new BookList();
        int currentPage = MAIN_PAGE;

        System.out.println(app.getGreeting() + "\n");

        MainMenu menu = new MainMenu();
        Router router = new Router(booklist);
        System.out.println(menu.toString());
        System.out.print("Please key your selection here: ");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        String parsedInput = CommandLineInputHelper.parseInput(userInput);
        String selectedOption = router.delegate(currentPage, menu, parsedInput);
        System.out.println("Selected " + selectedOption);


        while (selectedOption != EXIT) {
            if (selectedOption == BOOK_LIST) {
                currentPage = BOOK_REPO_PAGE;
            }
            if (currentPage == BOOK_REPO_PAGE) {
                menu = new BookRepositoryMenu();
                System.out.println("\n");
                System.out.println(booklist.toString() + "\n");
                System.out.println(menu.toString());
                System.out.print("Number of Book I would like to check out: ");
                userInput = scanner.next();
                parsedInput = CommandLineInputHelper.parseInput(userInput);
                selectedOption = router.delegate(currentPage, menu, parsedInput);
                if (!selectedOption.isEmpty()) {
                    System.out.println("\n Successfully checked out " + selectedOption);
                } else {
                    System.out.println("Unsuccessful checkout. Please select from book list again.");
                }
            } else {
                System.out.println(menu.toString());
                System.out.print("Please key your selection here: ");
                userInput = scanner.next();
                parsedInput = CommandLineInputHelper.parseInput(userInput);
                selectedOption = router.delegate(currentPage, menu, parsedInput);
                System.out.println("Selected " + selectedOption);
            }
        }
    }
}
