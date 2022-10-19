package com.kodilla.good.patterns.challenges;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {

        User buyer = new User("Stefan Stefanik");
        User seller = new User("Shiny Teeth Co.");
        Product product = new Toothbrush();
        Delivery delivery = new ParcelLocker(product);
        Payment payment = new CreditCardPayment();

        return new OrderRequest(buyer, seller, product, payment, delivery);
    }
}
