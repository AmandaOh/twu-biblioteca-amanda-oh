package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class MainMenu {

    Map<String, String> options = new HashMap<String, String>();

    public MainMenu() {
        options.put("1", "Book List");
        options.put("x", "exit");
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

}
