package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        Continent europe = new Continent("Europe");
        europe.addCountry("Poland", new BigDecimal(40000000));
        europe.addCountry("Germany", new BigDecimal(50000000));
        europe.addCountry("Spain", new BigDecimal(60000000));

        Continent africa = new Continent("Africa");
        africa.addCountry("Nigeria", new BigDecimal(150000000));
        africa.addCountry("Etiopia", new BigDecimal(100000000));
        africa.addCountry("Egypt", new BigDecimal(100000000));

        Continent asia = new Continent("Asia");
        asia.addCountry("China", new BigDecimal(1400000000));
        asia.addCountry("India", new BigDecimal(1300000000));

        World world = new World();
        world.addContinent(europe);
        world.addContinent(africa);
        world.addContinent(asia);

        //When
        BigDecimal totalPeople = world.getPeopleQuantity();

        //Then
        assertEquals(new BigDecimal("3200000000"), totalPeople);
    }
}
