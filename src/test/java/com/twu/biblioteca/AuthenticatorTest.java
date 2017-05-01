package com.twu.biblioteca;

import com.twu.biblioteca.models.User;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class AuthenticatorTest {

    private HashMap<String, User> users;

    User user1 = new User("RandomDude", "random@thoughtworks.com", 99946523, "passwordx", "001-1111");
    User user2 = new User("TestPerson", "test@thoughtworks.com", 87241563, "test123", "556-5555");

    private void LoadUserDataForTestCase() {
        users = new HashMap<>();
        users.put(user1.getLibraryNumber(), user1);
        users.put(user2.getLibraryNumber(), user2);
    }

    @Test
    public void authenticateTakesInLibraryNumberAndPasswordToReturnTrueIfSuccessfulLogIn() {
        LoadUserDataForTestCase();
        Authenticator authenticator = new Authenticator(users);
        assertTrue(authenticator.authenticate(user1.getLibraryNumber(),user1.getPassword()));
    }

    @Test
    public void authenticateReturnsFalseIfPasswordsDoNotMatch() {
        LoadUserDataForTestCase();
        Authenticator authenticator = new Authenticator(users);
        assertFalse(authenticator.authenticate(user1.getLibraryNumber(), "wrongPassword"));
    }

    @Test
    public void getUserReturnsUserIfUserExists() {
        LoadUserDataForTestCase();
        Authenticator authenticator = new Authenticator(users);
        assertEquals(user1, authenticator.getUser(user1.getLibraryNumber()));
    }

    @Test
    public void getUserRetunsNullIfUserDoesNotExist() {
        LoadUserDataForTestCase();
        Authenticator authenticator = new Authenticator(users);
        assertNull(authenticator.getUser("Wrong Library Number"));
    }

    @Test
    public void getLoggedInUserShouldContainUserObjectIfAuthenticationIsSuccessful() {
        LoadUserDataForTestCase();
        Authenticator authenticator = new Authenticator(users);
        authenticator.authenticate(user1.getLibraryNumber(), user1.getPassword());
        assertEquals(user1, authenticator.getLoggedInUser());
    }

    @Test
    public void getLoggedInUserShouldReturnNullIfAuthenticationHasFailed() {
        LoadUserDataForTestCase();
        Authenticator authenticator = new Authenticator(users);
        authenticator.authenticate(user1.getLibraryNumber(), "wrong password");
        assertNull(authenticator.getLoggedInUser());
    }

    @Test
    public void terminateReturnsTrueForSuccessfulLogOut() {
        LoadUserDataForTestCase();
        Authenticator authenticator = new Authenticator(users);
        authenticator.authenticate(user1.getLibraryNumber(), user1.getPassword());
        assertTrue(authenticator.terminate());
    }

    @Test
    public void terminateReturnsFalseForUnsuccessfulLogOut() {
        LoadUserDataForTestCase();
        Authenticator authenticator = new Authenticator(users);
        authenticator.authenticate(user1.getLibraryNumber(), "wrong password");
        assertFalse(authenticator.terminate());
    }

}