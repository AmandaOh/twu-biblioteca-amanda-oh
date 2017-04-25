package com.twu.biblioteca.repositories;

import com.twu.biblioteca.models.Loanable;

import java.util.List;
import java.util.stream.Collectors;

import static com.twu.biblioteca.models.Loanable.Status.AVAILABLE;
import static com.twu.biblioteca.models.Loanable.Status.NOT_AVAILABLE;

public class Library {

    private List<Loanable> loanables;
    private List<Loanable> filteredList;

    public Library(List<Loanable> loanables) {
        this.loanables = loanables;
    }

    private Loanable getLoanable(String selection) throws Exception {
        int index;
        Loanable loanable;
        try {
            index = Integer.parseInt(selection) - 1;
            loanable = filteredList.get(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            loanable = null;
        } catch (NumberFormatException e) {
            throw e;
        }
        return loanable;
    }

    public Loanable checkOut(String number, Class type) {
        filteredList = loanables.stream().filter(item -> item.getStatus() == AVAILABLE && item.getClass() == type).collect(Collectors.toList());
        Loanable itemToCheckOut;
        try {
            itemToCheckOut = getLoanable(number);
            itemToCheckOut.setStatus(NOT_AVAILABLE);
        } catch (Exception e){
            itemToCheckOut = null;
        }
        return itemToCheckOut;
    }

    public Loanable returnItem(String number) {
        filteredList = loanables.stream().filter(item -> item.getStatus() == NOT_AVAILABLE).collect(Collectors.toList());
        Loanable bookToCheckOut;
        try {
            bookToCheckOut = getLoanable(number);
            bookToCheckOut.setStatus(AVAILABLE);
        } catch (Exception e){
            bookToCheckOut = null;
        }
        return bookToCheckOut;
    }

    public List<Loanable> filterBy(Loanable.Status status, Class type) {
        return loanables.stream().filter(item -> item.getStatus() == status && item.getClass() == type).collect(Collectors.toList());
    }

}
