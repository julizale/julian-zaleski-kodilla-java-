package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Bun.SESAME)
                .burgers(3)
                .ingredient(Ingredient.CHEESE)
                .ingredient(Ingredient.BACON)
                .sauce(Sauce.ISLANDS)
                .build();
        System.out.println(bigmac);

        //When
        Bun bun = bigmac.getBun();
        Sauce sauce = bigmac.getSauce();
        int burgers = bigmac.getBurgers();

        //Then
        assertEquals(Bun.SESAME, bun);
        assertEquals(Sauce.ISLANDS, sauce);
        assertEquals(3, burgers);
        assertEquals(2, bigmac.getIngredients().size());
    }

    @Test
    void testBigmacBuilderDefaults() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .build();
        System.out.println(bigmac);

        //When
        Bun bun = bigmac.getBun();
        Sauce sauce = bigmac.getSauce();
        int burgers = bigmac.getBurgers();

        //Then
        assertEquals(Bun.STANDARD, bun);
        assertEquals(Sauce.STANDARD, sauce);
        assertEquals(1, burgers);
        assertEquals(0, bigmac.getIngredients().size());
    }

    @Test
    void testBigmacBuilderThrowsException() {
        //Given, when & then
        assertThrows(IllegalStateException.class, ()-> new Bigmac.BigmacBuilder().burgers(0).build());
        assertThrows(IllegalStateException.class, ()-> new Bigmac.BigmacBuilder().burgers(5).build());
    }
}
