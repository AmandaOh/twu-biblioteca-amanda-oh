package com.twu.biblioteca.repositories;

import com.twu.biblioteca.InMemoryMoviesDatabase;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class MovieRepositoryTest {

    MovieRepository movieRepository = new MovieRepository();
    InMemoryMoviesDatabase inMemoryMoviesDatabase = mock(InMemoryMoviesDatabase.class);



}