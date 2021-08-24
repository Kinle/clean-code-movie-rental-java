package com.thoughtworks.movierental;

public class BlurayMovieType extends MovieType{
    @Override
    int getPriceCode() {
        return Movie.BLURAY;
    }

    @Override
    double amountFor(int daysRented) {
        return daysRented * 4;
    }
}
