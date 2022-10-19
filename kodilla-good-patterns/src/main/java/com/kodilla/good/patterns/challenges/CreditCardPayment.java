package com.kodilla.good.patterns.challenges;

public class CreditCardPayment implements Payment {

    @Override
    public boolean processPayment(User seller, User buyer, Product product) {
        System.out.println("Payment from " + buyer.getName() + " to " + seller.getName() +
                " for $" + product.getPrice() + " succesfull.");
        return true;
    }

    @Override
    public String getNameOfPaymentMethod() {
        return "CreditCardPayment";
    }
}
