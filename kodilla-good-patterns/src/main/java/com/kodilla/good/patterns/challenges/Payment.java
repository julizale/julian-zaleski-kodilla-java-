package com.kodilla.good.patterns.challenges;

public interface Payment {

    boolean processPayment (User seller, User buyer, Product product);
    String getNameOfPaymentMethod();
}
