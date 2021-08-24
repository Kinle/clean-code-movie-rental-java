package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each : rentals) {
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    each.amount() + "\n";
        }

        //add footer lines result
        result += "Amount owed is " + totalAmount() + "\n";
        result += "You earned " + totalFrequentRenterPoints()
                + " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        String result = "<h3>Rental Record for " + getName() + "<h3>";
        result += "<p>";
        for (Rental each : rentals) {
            //show figures for this rental
            result += each.getMovie().getTitle() + "<b>" +
                    each.amount() + "</b><br/>";
        }
        result += "</p>";

        //add footer lines result
        result += "<p>Amount owed is <b>" + totalAmount() + "</b></p>";
        result += "<p>You earned <b>" + totalFrequentRenterPoints()
                + "</b> frequent renter points</p>";
        return result;
    }

    private int totalFrequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::frequentRenterPoints).sum();
    }

    private double totalAmount() {
        return rentals.stream().mapToDouble(Rental::amount).sum();
    }

}
