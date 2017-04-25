package com.twu.biblioteca.models;

public interface Loanable {

    enum Status {
        AVAILABLE, NOT_AVAILABLE;
    }

    String getName();

    Status getStatus();

    void setStatus(Status status);

}
