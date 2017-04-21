package com.twu.biblioteca.menus;

import com.twu.biblioteca.Router;

import java.util.HashMap;
import java.util.Map;

public abstract class Menu {

    public static final String EXIT = "Exit";
    public static final String EXIT_COMMAND = "X";
    public static final String GO_BACK = "Back";
    public static final String GO_BACK_COMMAND = "B";
    public static final String NO_SUCH_OPTION = "Invalid Option";

    private Map<String, String> options = new HashMap<String, String>();

    public void addOption(String shortCommand, String option) {
        this.options.put(shortCommand, option);
    }

    public Map<String, String> getOptions() {
        return this.options;
    }

    public String getOption(String s) {
        String userInput = s.toUpperCase();
        String option = this.options.get(userInput) == null ? MainMenu.NO_SUCH_OPTION : this.options.get(userInput);
        return option;
    }

    public String toString() {
        StringBuilder menuOptions = new StringBuilder();
        for(Map.Entry<String, String> option : this.options.entrySet()) {
            menuOptions.append("SELECT [" + option.getKey() + "]");
            menuOptions.append(" FOR " + option.getValue());
            menuOptions.append("\n");
        }
        return "\n" + menuOptions.toString() + "\n" + "Please key your selection here: ";
    }

    public void removeOption(String shortCommand) {
        this.options.remove(shortCommand.toUpperCase());
    }

    public abstract String executeRouterRequest(Router router, String input);

}
