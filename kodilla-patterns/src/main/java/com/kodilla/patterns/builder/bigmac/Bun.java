package com.kodilla.patterns.builder.bigmac;

public enum Bun {

    STANDARD,
    SESAME;

    @Override
    public String toString() {
        return switch (this) {
            case STANDARD -> "standard bun";
            case SESAME -> "bun with sesame seeds";
        };
    }
}
