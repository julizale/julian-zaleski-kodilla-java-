package com.kodilla.patterns.builder.bigmac;

public enum Sauce {

    STANDARD,
    ISLANDS,
    BARBECUE;

    @Override
    public String toString() {
        return switch (this) {
            case ISLANDS -> "1000 islands";
            case BARBECUE -> "barbecue";
            case STANDARD -> "standard";
        };
    }
}
