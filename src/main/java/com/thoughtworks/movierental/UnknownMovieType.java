package com.thoughtworks.movierental;

public class UnknownMovieType extends MovieType{

    private final int priceCode;

    public UnknownMovieType(int priceCode) {
        this.priceCode = priceCode;
    }

    @Override
    int getPriceCode() {
        return priceCode;
    }

    @Override
    double amountFor(int daysRented) {
        return 0;
    }
}
