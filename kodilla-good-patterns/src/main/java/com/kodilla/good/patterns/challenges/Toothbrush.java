package com.kodilla.good.patterns.challenges;

public class Toothbrush implements Product {

    @Override
    public String getName() {
        return "Toothbrush";
    }

    @Override
    public double getWeight() {
        return 0.1;
    }

    @Override
    public double getPrice() {
        return 8.99;
    }

}
