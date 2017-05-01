package com.twu.biblioteca.models;

public class User {

    private String name;
    private String emailAddress;
    private int phoneNumber;
    private String password;
    private String libraryNumber;

    public User(String name, String emailAddress, int phoneNumber, String password, String libraryNumber) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.libraryNumber = libraryNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

}
