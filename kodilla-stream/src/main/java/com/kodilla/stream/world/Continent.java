package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class Continent {

    private final String name;
    private final List<Country> countries = new ArrayList<>();

    public Continent(final String name) {
        this.name = name;
    }

    public List<Country> getCountries() {
        return new ArrayList<>(countries);
    }

    public String getName() {
        return name;
    }

    public void addCountry(String name, BigDecimal peopleQuantity) {
        countries.add(new Country(name, peopleQuantity));
    }
}
