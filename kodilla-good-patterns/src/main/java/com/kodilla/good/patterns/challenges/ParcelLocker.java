package com.kodilla.good.patterns.challenges;

public class ParcelLocker implements Delivery {

    private final Product product;
    public ParcelLocker(final Product product) {
        this.product = product;
    }

    @Override
    public int getDeliveryTime(Product product) {
        if (product.getWeight() > 10) {
            return 2;
        } else {
            return 1;
        }
    }

    @Override
    public String getNameOfDeliveryMethod() {
        return "ParcelLocker";
    }

}
