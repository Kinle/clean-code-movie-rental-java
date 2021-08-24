package com.thoughtworks.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {

    public double totalAmount() {
        return stream().mapToDouble(Rental::amount).sum();
    }

    public int totalFrequentRenterPoints() {
        return stream().mapToInt(Rental::frequentRenterPoints).sum();
    }
}
