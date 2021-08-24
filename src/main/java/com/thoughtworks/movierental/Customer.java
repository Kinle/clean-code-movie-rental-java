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
        return header() + body() + footer();
    }

    public String htmlStatement() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String header() {
        return "Rental Record for " + name + "\n";
    }

    private String body() {
        String result = "";
        for (Rental each : rentals) {
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    each.amount() + "\n";
        }
        return result;
    }

    private String footer() {
        String result = "Amount owed is " + totalAmount() + "\n";
        result += "You earned " + totalFrequentRenterPoints()
                + " frequent renter points";
        return result;
    }

    private String htmlHeader() {
        return "<h3>Rental Record for " + name + "<h3>";
    }

    private String htmlBody() {
        String result = "<p>";
        for (Rental each : rentals) {
            //show figures for this rental
            result += each.getMovie().getTitle() + "<b>" +
                    each.amount() + "</b><br/>";
        }
        result += "</p>";
        return result;
    }

    private String htmlFooter() {
        String result = "";
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
