package com.kodilla.good.patterns.flight.database;

public class Application {

    public static void main(String[] args) {
        FlightDatabase flightDatabase = new SimpleFlightDatabase();
        System.out.println(flightDatabase.getFlightsFrom("Katowice"));
        System.out.println(flightDatabase.getFlightsTo("Gdańsk"));
        System.out.println(flightDatabase.getFlightsWithConnection("Katowice", "Gdańsk"));
        System.out.println(flightDatabase.getFlightsWithSpecifiedConnection("Gdańsk",
                "Kraków", "Wrocław"));
    }
}
