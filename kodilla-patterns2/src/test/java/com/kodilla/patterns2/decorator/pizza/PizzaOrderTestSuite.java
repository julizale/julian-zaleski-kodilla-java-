package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    void testHawaiianToGoXXLgetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new XXLDecorator(pizzaOrder);
        pizzaOrder = new AddonHamDecorator(pizzaOrder);
        pizzaOrder = new AddonPineappleDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.getDescription();
        System.out.println(description);
        //Then
        assertEquals("Pizza size XXL + ham + pineapple", description);
    }

    @Test
    void testHawaiianToGoXXLgetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new XXLDecorator(pizzaOrder);
        pizzaOrder = new AddonHamDecorator(pizzaOrder);
        pizzaOrder = new AddonPineappleDecorator(pizzaOrder);
        //When
        BigDecimal cost = pizzaOrder.getCost();
        System.out.println(cost);
        //Then
        assertEquals(new BigDecimal(33.0), cost);
    }

    @Test
    void testCappriciosaXtraCheeseDeliveryGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new AddonHamDecorator(pizzaOrder);
        pizzaOrder = new AddonMushroomsDecorator(pizzaOrder);
        pizzaOrder = new XtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new DeliveryDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.getDescription();
        System.out.println(description);
        //Then
        assertEquals("Pizza + ham + mushrooms + extra cheese + delivery", description);
    }

    @Test
    void testCappriciosaXtraCheeseDeliveryGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new AddonHamDecorator(pizzaOrder);
        pizzaOrder = new AddonMushroomsDecorator(pizzaOrder);
        pizzaOrder = new XtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new DeliveryDecorator(pizzaOrder);
        //When
        BigDecimal cost = pizzaOrder.getCost();
        System.out.println(cost);
        //Then
        assertEquals(new BigDecimal(37.0), cost);
    }
}
