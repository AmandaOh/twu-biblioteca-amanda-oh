package com.twu.biblioteca.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandLineInputHelperTest {
    @Test
    public void shouldReturnAStringOfLength1() {
        assertTrue(CommandLineInputHelper.parseInput("1").length() == 1);
        assertTrue(CommandLineInputHelper.parseInput("12398234").length() == 1);
    }

    @Test
    public void returnsString1WhenUserInputs1() {
        assertEquals("1", CommandLineInputHelper.parseInput("1"));
    }

    @Test
    public void returnsString1WhenUserInputsAnyStringStartingWith1() {
        assertEquals("1", CommandLineInputHelper.parseInput("1sdkgfd"));
    }
    
}