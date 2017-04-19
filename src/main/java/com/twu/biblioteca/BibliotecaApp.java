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
        System.out.print("Your selection: ");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();

        while (!userInput.equals(CommandLineInputHelper.exit())) {
            String parsedInput = CommandLineInputHelper.parseInput(userInput);
            System.out.println("Selected " + menu.getOption(parsedInput));
            if (menu.getOption(parsedInput).equals("Book List")) {
                BookList booklist = new BookList();
                System.out.println(booklist.toString());
            }
            System.out.println(menu.toString());
            System.out.print("Your selection: ");
            userInput = scanner.next();
        }
    }
}

