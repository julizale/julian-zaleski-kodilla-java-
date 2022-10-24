package com.kodilla.good.patterns.flight.database;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface FlightDatabase {

    List<Flight> getFlightsFrom(String departureAirport);
    List<Flight> getFlightsTo(String arrivalAirport);
    List<Journey> getFlightsWithConnection(String departureAirport, String arrivalAirport);
    List<Flight> getFlightsWithSpecifiedConnection(String departureAirport, String connectionAirport, String arrivalAirport);
}
