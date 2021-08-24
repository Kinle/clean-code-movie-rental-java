package com.thoughtworks.movierental;

public class NewReleaseMovieType extends MovieType{
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double amountFor(int daysRented) {
        return daysRented * 3;
    }
}
