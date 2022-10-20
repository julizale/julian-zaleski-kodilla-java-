package com.kodilla.good.patterns.food2door;

public class HealthyShop implements FoodShop {

    @Override
    public boolean process(OrderRequest orderRequest) {
        System.out.println("Sending message to Barbara to call Mr Jaskowiak farm to deliver products to FoodToDoor");
        return true;
    }

}
