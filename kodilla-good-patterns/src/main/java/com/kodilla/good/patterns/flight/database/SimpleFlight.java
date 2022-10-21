package com.kodilla.good.patterns.flight.database;

import java.util.Objects;

public class SimpleFlight implements Flight {

    private final String departureAirport;
    private final String arrivalAirport;

    public SimpleFlight(final String departureAirport, final String arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleFlight that = (SimpleFlight) o;
        return departureAirport.equals(that.departureAirport) && arrivalAirport.equals(that.arrivalAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureAirport, arrivalAirport);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                '}';
    }
}
