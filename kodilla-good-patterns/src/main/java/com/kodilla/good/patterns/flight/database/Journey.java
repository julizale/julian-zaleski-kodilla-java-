package com.kodilla.good.patterns.flight.database;

public class Journey {

    Flight flight1;
    Flight flight2;

    public Journey(Flight flight1, Flight flight2) {
        this.flight1 = flight1;
        this.flight2 = flight2;
    }

    public Flight getFlight1() {
        return flight1;
    }

    public Flight getFlight2() {
        return flight2;
    }

    @Override
    public String toString() {
        return "Journey{" +
                "flight1=" + flight1 +
                ", flight2=" + flight2 +
                '}';
    }
}
