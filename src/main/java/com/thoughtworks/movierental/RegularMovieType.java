package com.thoughtworks.movierental;

public class RegularMovieType extends MovieType{
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    double amountFor(int daysRented) {
        double amount = 2;
        if (daysRented > 2)
            amount += (daysRented - 2) * 1.5;
        return amount;
    }

    @Override
    int frequentRenterPoints(int daysRented) {
        return 1;
    }
}
