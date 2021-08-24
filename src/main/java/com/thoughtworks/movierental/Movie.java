package com.thoughtworks.movierental;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private MovieType movieType;

    @Deprecated
    public Movie(String title, int priceCode) {
        this.title = title;
        this.setPriceCode(priceCode);
    }

    public Movie(String title, MovieType movieType){
        this.title = title;
        this.movieType = movieType;
    }

    public int getPriceCode() {
        return movieType.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
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
                movieType = new UnknownMovieType(priceCode);
        }
    }

    public String getTitle() {
        return title;
    }

    public boolean isNewRelease() {
        return getPriceCode() == NEW_RELEASE;
    }

    public double amountFor(int daysRented) {
        return movieType.amountFor(daysRented);
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