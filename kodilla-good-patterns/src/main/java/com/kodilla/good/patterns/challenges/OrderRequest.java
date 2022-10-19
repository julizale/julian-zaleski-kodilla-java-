package com.kodilla.good.patterns.challenges;

public record OrderRequest(User buyer, User seller, Product product, Payment payment, Delivery delivery) {

}
