package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AddonMushroomsDecorator extends AbstractPizzaOrderDecorator {

    public AddonMushroomsDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(4.00));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + mushrooms";
    }
}
