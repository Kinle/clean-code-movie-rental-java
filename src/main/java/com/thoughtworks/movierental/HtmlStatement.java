package com.thoughtworks.movierental;

class HtmlStatement {

    private final String name;
    private final Rentals rentals;
    private final double totalAmount;
    private final int totalFrequentRenterPoints;

    public HtmlStatement(String customerName, Rentals rentals) {
        name = customerName;
        this.rentals = rentals;
        totalAmount = rentals.totalAmount();
        totalFrequentRenterPoints = rentals.totalFrequentRenterPoints();
    }

    public String generate() {
        return htmlHeader() + htmlBody() + htmlFooter();
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
        result += "<p>Amount owed is <b>" + totalAmount + "</b></p>";
        result += "<p>You earned <b>" + totalFrequentRenterPoints
                + "</b> frequent renter points</p>";
        return result;
    }
}
