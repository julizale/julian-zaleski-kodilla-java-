package com.kodilla.good.patterns.food2door;

public class GlutenFreeShop implements FoodShop {

    @Override
    public boolean process(OrderRequest orderRequest) {
        return switch (orderRequest.product()) {
            case "Corn flour" -> orderRequest.quantity() < 8;
            case "Soy sausage" -> orderRequest.quantity() < 12;
            case "Tofu" -> orderRequest.quantity() < 27;
            default -> false;
        };
    }
}
