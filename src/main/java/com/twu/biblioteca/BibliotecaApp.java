package com.twu.biblioteca;

import com.twu.biblioteca.menus.BookRepositoryMenu;
import com.twu.biblioteca.menus.MainMenu;
import com.twu.biblioteca.utils.CommandLineInputHelper;

import java.util.Scanner;

import static com.twu.biblioteca.menus.MainMenu.EXIT;

public class BibliotecaApp {

    public String getGreeting() {
        return "Hi there, welcome to our library.";
    }

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        BookRepository books = new BookRepository();

        System.out.println(app.getGreeting());

        MainMenu menu = new MainMenu(books);
        Router router = new Router(menu);
        System.out.println(menu.toString());

        Scanner scanner = new Scanner(System.in);
        String selectedOption = readSelectedOption(router, scanner);

        while (selectedOption != EXIT) {
            System.out.println(router.getPrintedResponse());
            selectedOption = readSelectedOption(router, scanner);
        }

    }

    private static String readSelectedOption(Router router, Scanner scanner) {
        String userInput = scanner.next();
        String parsedInput = CommandLineInputHelper.parseInput(userInput);
        return router.getSelectedOption(parsedInput);
    }
}
