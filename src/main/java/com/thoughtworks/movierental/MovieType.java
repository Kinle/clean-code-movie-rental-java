package com.thoughtworks.movierental;

public abstract class MovieType {
    abstract int getPriceCode();
    abstract double amountFor(int daysRented);
    abstract int frequentRenterPoints(int daysRented);
}
