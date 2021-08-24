package com.thoughtworks.movierental;

public class ChildrenMovieType extends MovieType{
    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }
}
