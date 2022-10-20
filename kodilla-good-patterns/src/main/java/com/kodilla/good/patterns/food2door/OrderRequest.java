package com.kodilla.good.patterns.food2door;

public record OrderRequest(FoodShop foodShop, String product, int quantity) {
}
