package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class MainMenu {

    Map<String, String> options = new HashMap<String, String>();

    public MainMenu() {
        addOption("1", "Book List");
        addOption("x", "Exit");
    }

    private void addOption(String shortCommand, String option) {
        options.put(shortCommand.toLowerCase(), option.toLowerCase());
    }


    public Map<String, String> getOptions() {
        return options;
    }

    public String getOption(String s) {
        String option = options.get(s) == null ? "Invalid Option" : options.get(s);
        return option;
    }

    public String toString() {
        StringBuilder menuOptions = new StringBuilder();
        for(Map.Entry<String, String> option : options.entrySet()) {
            menuOptions.append("SELECT [" + option.getKey() + "]");
            menuOptions.append(" FOR " + option.getValue());
            menuOptions.append("\n");
        }
        return menuOptions.toString();
    }

    public void removeOption(String shortCommand) {
        options.remove(shortCommand.toLowerCase());
    }
}
