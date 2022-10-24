package com.kodilla.good.patterns.flight.database;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleFlightDatabase implements FlightDatabase {

     Set<Flight> flights;

    public SimpleFlightDatabase() {
        flights = new HashSet<>();
        flights.add(new SimpleFlight("Katowice", "Gdańsk"));
        flights.add(new SimpleFlight("Gdańsk", "Kraków"));
        flights.add(new SimpleFlight("Wrocław", "Gdańsk"));
        flights.add(new SimpleFlight("Radom", "Gdańsk"));
        flights.add(new SimpleFlight("Katowice", "Radom"));
        flights.add(new SimpleFlight("Warszawa", "Gdańsk"));
        flights.add(new SimpleFlight("Kraków", "Wrocław"));
    }

    @Override
    public List<Flight> getFlightsFrom(String departureAirport) {
        return flights.stream()
                .filter(flight -> departureAirport.equals(flight.getDepartureAirport()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> getFlightsTo(String arrivalAirport) {
        return flights.stream()
                .filter(flight -> arrivalAirport.equals(flight.getArrivalAirport()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Journey> getFlightsWithConnection(String departureAirport, String arrivalAirport) {
        ArrayList<Journey> journeys = new ArrayList<>();
        for (Flight flightFrom : getFlightsFrom(departureAirport)) {
            for (Flight flightTo: getFlightsTo(arrivalAirport)) {
                if (flightFrom.getArrivalAirport().equals(flightTo.getDepartureAirport())) {
                    journeys.add(new Journey(flightFrom, flightTo));
                }
            }
        }
        return journeys;
    }

    @Override
    public List<Flight> getFlightsWithSpecifiedConnection(String departureAirport, String connectionAirport, String arrivalAirport) {
        List<Flight> result = new ArrayList<>();
        Flight flight1 = new SimpleFlight(departureAirport, connectionAirport);
        Flight flight2 = new SimpleFlight(connectionAirport, arrivalAirport);
        if (flights.contains(flight1) && flights.contains(flight2)) {
            result.add(flight1);
            result.add(flight2);
        }
        return result;
    }

}
