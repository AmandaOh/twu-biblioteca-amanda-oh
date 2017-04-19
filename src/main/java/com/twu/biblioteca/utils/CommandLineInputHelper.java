package com.twu.biblioteca.utils;

public abstract class CommandLineInputHelper {

    public static String parseInput(String command){
        String commandInput = command.length() == 1 ? command : command.substring(0, 1);
        return commandInput;
    }

}
