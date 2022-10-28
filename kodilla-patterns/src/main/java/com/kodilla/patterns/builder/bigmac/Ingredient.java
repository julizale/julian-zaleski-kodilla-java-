package com.kodilla.patterns.builder.bigmac;

public enum Ingredient {

    LETTUCE,
    ONION,
    BACON,
    CUCUMBER,
    CHILLI,
    MUSHROOMS,
    SHRIMP,
    CHEESE;

    @Override
    public String toString() {
        return switch (this) {
            case BACON -> "bacon";
            case ONION -> "onion";
            case CHEESE -> "cheese";
            case CHILLI -> "chilli";
            case SHRIMP -> "shrimp";
            case LETTUCE -> "lettuce";
            case CUCUMBER -> "cucumber";
            case MUSHROOMS -> "mushrooms";
        };
    }
}
