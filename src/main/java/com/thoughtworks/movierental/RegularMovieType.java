package com.thoughtworks.movierental;

public class RegularMovieType extends MovieType{
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }
}
