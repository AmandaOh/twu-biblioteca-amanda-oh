package com.twu.biblioteca.databases;

import com.twu.biblioteca.models.User;

import java.util.HashMap;

public class InMemoryUsersDatabase {

    private HashMap<String, User> users;

    public InMemoryUsersDatabase() {
        users = loadUsers();
    }

    private HashMap<String, User> loadUsers() {
        users = new HashMap<>();
        User user1 = new User ("Amanda", "amandaoh@thoughtworks.com", 94746913, "mannie123", "123-4567");
        User user2 = new User ("Terence", "terence@thoughtworks.com", 92736912, "competitiveBoy", "123-4568");
        users.put(user1.getLibraryNumber(), user1);
        users.put(user2.getLibraryNumber(), user2);
        return users;
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

}
