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

    @Override
    int frequentRenterPoints(int daysRented) {
        if (isBonusApplicable(daysRented)) {
            return 2;
        }
        return 1;
    }

    private boolean isBonusApplicable(int daysRented) {
        return daysRented > 1;
    }
}
