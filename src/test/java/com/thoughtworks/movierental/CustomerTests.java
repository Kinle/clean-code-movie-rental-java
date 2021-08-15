package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    public void shouldGenerateStatement() {
        Customer customer = new Customer("John Doe");

        customer.addRental(new Rental(new Movie("Jumanji", Movie.CHILDRENS), 2));
        customer.addRental(new Rental(new Movie("3 idiots", Movie.REGULAR), 4));
        customer.addRental(new Rental(new Movie("Avengers", Movie.NEW_RELEASE), 15));

        String statement = customer.statement();

        assertEquals(statement, "Rental Record for John Doe\n" +
                "\tJumanji\t1.5\n" +
                "\t3 idiots\t5.0\n" +
                "\tAvengers\t45.0\n" +
                "Amount owed is 51.5\n" +
                "You earned 4 frequent renter points");
    }
}