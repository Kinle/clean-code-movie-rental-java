package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalTests {
    @Test
    public void amountForRegularMovie() {
        Rental rental = new Rental(new Movie("Regular", new RegularMovieType()), 4);

        double amount = rental.amount();

        assertEquals(5.0, amount, 0.0);
    }

    @Test
    public void amountForNewReleaseMovie() {
        Rental rental = new Rental(new Movie("New Release", new NewReleaseMovieType()), 4);

        double amount = rental.amount();

        assertEquals(12, amount, 0.0);
    }

    @Test
    public void amountForChildrenMovie() {
        Rental rental = new Rental(new Movie("Children", new ChildrenMovieType()), 4);

        double amount = rental.amount();

        assertEquals(3.0, amount, 0.0);
    }

    @Test
    public void amountForBlurayMovie() {
        Rental rental = new Rental(new Movie("Bluray", new BlurayMovieType()), 4);

        double amount = rental.amount();

        assertEquals(16.0, amount, 0.0);
    }

    @Test
    public void amountForUnknownMovie() {
        Rental rental = new Rental(new Movie("Unknown", new UnknownMovieType(4)), 4);

        double amount = rental.amount();

        assertEquals(0.0, amount, 0.0);
    }

    @Test
    public void frequentRenterPointsForRegularMovie() {
        Rental rental = new Rental(new Movie("Regular", new RegularMovieType()), 4);

        int frequentRenterPoints = rental.frequentRenterPoints();

        assertEquals(1, frequentRenterPoints);
    }

    @Test
    public void frequentRenterPointsForNewReleaseMovie() {
        Rental rental = new Rental(new Movie("New Release", new NewReleaseMovieType()), 4);

        int frequentRenterPoints = rental.frequentRenterPoints();

        assertEquals(2, frequentRenterPoints);
    }

    @Test
    public void frequentRenterPointsForChildrenMovie() {
        Rental rental = new Rental(new Movie("Children", new ChildrenMovieType()), 4);

        int frequentRenterPoints = rental.frequentRenterPoints();

        assertEquals(1, frequentRenterPoints);
    }

    @Test
    public void frequentRenterPointsForBlurayMovie() {
        Rental rental = new Rental(new Movie("Bluray", new BlurayMovieType()), 4);

        int frequentRenterPoints = rental.frequentRenterPoints();

        assertEquals(3, frequentRenterPoints);
    }

    @Test
    public void frequentRenterPointsForUnknownMovie() {
        Rental rental = new Rental(new Movie("Unknown", new UnknownMovieType(4)), 4);

        int frequentRenterPoints = rental.frequentRenterPoints();

        assertEquals(0, frequentRenterPoints);
    }
}
