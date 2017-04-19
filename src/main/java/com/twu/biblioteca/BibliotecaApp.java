package com.twu.biblioteca;

import com.twu.biblioteca.utils.CommandLineInputHelper;

import java.util.Scanner;

public class BibliotecaApp {


    public String getGreeting() {
        return "Hi there, welcome to our library.";
    }

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        System.out.println(app.getGreeting());

        MainMenu menu = new MainMenu();
        System.out.println(menu.toString());
        System.out.print("Please key your selection here: ");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        String parsedInput = CommandLineInputHelper.parseInput(userInput);
        String selectedOption = menu.getOption(parsedInput);

        while (!selectedOption.equals("exit")) {
            System.out.println("Selected " + selectedOption);
            if (selectedOption.equals("book list")) {
                System.out.println("\n");
                BookList booklist = new BookList();
                System.out.println(booklist.toString());
            }
            System.out.println(menu.toString());
            System.out.print("Please key your selection here: ");
            userInput = scanner.next();
            parsedInput = CommandLineInputHelper.parseInput(userInput);
            selectedOption = menu.getOption(parsedInput);
        }
    }
}

