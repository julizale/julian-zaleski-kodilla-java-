package com.kodilla.bubbles;

public class CharToIntegerInputMapper {

    public int mapCharToInteger(char ch) throws IllegalArgumentException {
        String charactersAllowed = "0123456789";
        if (charactersAllowed.indexOf(ch) == -1) throw new IllegalArgumentException("This character is not a number!");
        return Character.getNumericValue(ch);
    }
}
