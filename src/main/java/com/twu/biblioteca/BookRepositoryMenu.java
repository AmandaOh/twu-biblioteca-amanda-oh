package com.twu.biblioteca;

public class BookRepositoryMenu extends MainMenu{

    public static final String GO_BACK = "Back";
    public static final String GO_BACK_COMMAND = "B";

    public BookRepositoryMenu() {
        addOption(GO_BACK_COMMAND, GO_BACK);
        removeOption("1");
    }

}
