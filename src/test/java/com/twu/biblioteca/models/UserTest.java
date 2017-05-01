package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    User user = new User("RandomDude", "random@thoughtworks.com", 99946523, "passwordx", "001-1111");

    @Test
    public void getNameReturnsNameOfUser() throws Exception {
        assertEquals("RandomDude", user.getName());
    }

    @Test
    public void getEmailAddressReturnsEmailOfUser() throws Exception {
        assertEquals("random@thoughtworks.com", user.getEmailAddress());
    }

    @Test
    public void getPhoneNumberReturnsNumberOfUser() throws Exception {
        assertEquals(99946523, user.getPhoneNumber());
    }

    @Test
    public void getPassword() throws Exception {
        assertEquals("passwordx", user.getPassword());
    }

    @Test
    public void getLibraryNumber() {
        assertEquals("001-1111", user.getLibraryNumber());
    }

}