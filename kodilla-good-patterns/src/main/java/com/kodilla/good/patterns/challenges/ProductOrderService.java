package com.kodilla.good.patterns.challenges;

public class ProductOrderService {

    public boolean order (final User buyer, final User seller, final Product product,
                          final Payment payment, final Delivery delivery) {
        if (payment.processPayment(seller, buyer, product)) {
            System.out.println("Order successfull. " + product.getName() + " will be delivered in " +
                    delivery.getDeliveryTime(product) + " days.");
            return true;
        } else {
            System.out.println("Order rejected.");
            return false;
        }
    }

}