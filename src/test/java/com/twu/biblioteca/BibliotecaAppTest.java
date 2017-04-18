package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class BibliotecaAppTest {
    @Test
    public void testAppHasAGreeting() {
        BibliotecaApp ba = new BibliotecaApp();
        assertNotNull("app should have a greeting", ba.getGreeting());
    }
}