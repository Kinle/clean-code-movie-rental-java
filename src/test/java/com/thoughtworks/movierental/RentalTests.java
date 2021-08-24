package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalTests {
    @Test
    public void amountForRegularMovie() {
        Rental rental = new Rental(new Movie("Regular", Movie.REGULAR), 4);

        double amount = rental.amount();

        assertEquals(5.0, amount, 0.0);
    }

    @Test
    public void amountForNewReleaseMovie() {
        Rental rental = new Rental(new Movie("New Release", Movie.NEW_RELEASE), 4);

        double amount = rental.amount();

        assertEquals(12, amount, 0.0);
    }

    @Test
    public void amountForChildrenMovie() {
        Rental rental = new Rental(new Movie("Children", Movie.CHILDRENS), 4);

        double amount = rental.amount();

        assertEquals(3.0, amount, 0.0);
    }

    @Test
    public void amountForUnknownMovie() {
        Rental rental = new Rental(new Movie("Unknown", 4), 4);

        double amount = rental.amount();

        assertEquals(0.0, amount, 0.0);
    }
}
