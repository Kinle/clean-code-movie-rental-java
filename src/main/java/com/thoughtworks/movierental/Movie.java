package com.thoughtworks.movierental;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int arg) {
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }

    public boolean isNewRelease() {
        return priceCode == NEW_RELEASE;
    }

    public double amountFor(int daysRented) {
        switch (priceCode) {
            case REGULAR:
                return regularMovieAmountFor(daysRented);
            case NEW_RELEASE:
                return newReleaseAmountFor(daysRented);
            case CHILDRENS:
                return childrenMovieAmountFor(daysRented);
            default:
                return 0;
        }
    }

    private double regularMovieAmountFor(int daysRented) {
        double amount = 2;
        if (daysRented > 2)
            amount += (daysRented - 2) * 1.5;
        return amount;
    }

    private double newReleaseAmountFor(int daysRented) {
        return daysRented * 3;
    }

    private double childrenMovieAmountFor(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5;
        return amount;
    }

    public int frequentRenterPoints(int daysRented) {
        if (isBonusApplicable(daysRented)) {
            return 2;
        }
        return 1;
    }

    private boolean isBonusApplicable(int daysRented) {
        return isNewRelease()
                &&
                daysRented > 1;
    }
}