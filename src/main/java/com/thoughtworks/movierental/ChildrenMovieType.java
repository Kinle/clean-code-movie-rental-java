package com.thoughtworks.movierental;

public class ChildrenMovieType extends MovieType{
    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    double amountFor(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5;
        return amount;
    }

    @Override
    int frequentRenterPoints(int daysRented) {
        return 1;
    }
}
