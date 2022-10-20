package com.kodilla.good.patterns.food2door;

public class ExtraFoodShop implements FoodShop{

    @Override
    public boolean process(OrderRequest orderRequest) {
        if (checkInWarehouse(orderRequest.product(), orderRequest.quantity())) {
            sendToFood2Door(orderRequest.product(), orderRequest.quantity());
            return true;
        } else {
            return false;
        }
    }

    private boolean checkInWarehouse(String product, int quantity) {
        return product.equals("Kabanosy premium") && quantity < 10;
    }

    private void sendToFood2Door (String product, int quantity) {
        System.out.println("Sending " + quantity + " pcs. of " + product + " to Food2Door");
    }
}
