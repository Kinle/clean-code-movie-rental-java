package com.thoughtworks.movierental;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private MovieType movieType;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return movieType.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                movieType = new RegularMovieType();
                break;
            case NEW_RELEASE:
                movieType = new NewReleaseMovieType();
                break;
            case CHILDRENS:
                movieType = new ChildrenMovieType();
                break;
            default:
                throw new IllegalArgumentException("Unknown movie type");
        }
    }

    public String getTitle() {
        return title;
    }

    public boolean isNewRelease() {
        return getPriceCode() == NEW_RELEASE;
    }

    public double amountFor(int daysRented) {
        switch (getPriceCode()) {
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