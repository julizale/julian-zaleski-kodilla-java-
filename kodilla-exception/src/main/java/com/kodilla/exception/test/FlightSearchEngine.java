package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearchEngine {

    public boolean findFlight (Flight flight) throws RouteNotFoundException {

        Map<String, Boolean> destinations = new HashMap<>();
        destinations.put("Paris", true);
        destinations.put("Warsaw", true);
        destinations.put("New York", true);
        destinations.put("Belfast", false);
        destinations.put("Katowice", false);

        if (destinations.containsKey(flight.getArrivalAirport())) {
            return true;
        } else {
            throw new RouteNotFoundException("No such airport in database!");
        }
    }

    public static void main(String[] args) {

        FlightSearchEngine engine = new FlightSearchEngine();
        Flight flight = new Flight("Katowice", "Addis Ababa");

        try {
            if (engine.findFlight(flight)) {
                System.out.println("Flight to " + flight.getArrivalAirport() +
                        " found in database.");
            } else {
                System.out.println(flight.getArrivalAirport() +
                        " found in database, but we have no flights at that destination.");
            }
        } catch (RouteNotFoundException e) {
            System.out.println("Exception occured: " + e);
        } finally {
            System.out.println("Try search for flight to " + flight.getArrivalAirport() +
                    " has been peformed.");
        }
    }
}
