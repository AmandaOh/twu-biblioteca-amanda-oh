package com.twu.biblioteca;

import com.twu.biblioteca.models.User;

import java.util.HashMap;

public class Authenticator {

    private HashMap<String, User> users;

    private static User loggedInUser = null;

    public Authenticator(HashMap<String, User> users) {
        this.users = users;
    }

    public boolean authenticate(String libraryNumber, String password) {
        User user = users.get(libraryNumber);
        if (passwordMatch(password, user)) {
            loggedInUser = user;
            return true;
        }
        loggedInUser = null;
        return false;
    }

    private boolean passwordMatch(String password, User user) {
        return user.getPassword().equals(password);
    }

    public User getUser(String libraryNumber) {
        return users.get(libraryNumber);
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public boolean terminate() {
        if (loggedInUser == null) {
            return false;
        }
        loggedInUser = null;
        return true;
    }

}

