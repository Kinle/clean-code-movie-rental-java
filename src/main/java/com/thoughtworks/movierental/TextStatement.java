package com.thoughtworks.movierental;

class TextStatement {

    private final double totalAmount;
    private final int totalFrequentRenterPoints;
    private final String customerName;
    private final Rentals rentals;

    public TextStatement(String customerName, Rentals rentals) {
        this.customerName = customerName;
        this.rentals = rentals;
        this.totalAmount = rentals.totalAmount();
        this.totalFrequentRenterPoints = rentals.totalFrequentRenterPoints();

    }

    public String generate() {
        return header() + body() + footer();
    }

    private String header() {
        return "Rental Record for " + customerName + "\n";
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
        String result = "Amount owed is " + totalAmount + "\n";
        result += "You earned " + totalFrequentRenterPoints
                + " frequent renter points";
        return result;
    }
}
