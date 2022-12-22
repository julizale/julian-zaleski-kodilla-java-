package com.kodilla.bubbles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharToIntegerInputMapperTest {

    @Test
    void testMapCharToIntegerThrowsExceptionWhenLetter() {
        //Given
        CharToIntegerInputMapper charToIntegerInputMapper = new CharToIntegerInputMapper();

        //When & Then
        assertThrows(IllegalArgumentException.class, () -> charToIntegerInputMapper.mapCharToInteger('X'));
    }

    @Test
    void testMapCharToIntegerThrowsExceptionWhenSign() {
        //Given
        CharToIntegerInputMapper charToIntegerInputMapper = new CharToIntegerInputMapper();

        //When & Then
        assertThrows(IllegalArgumentException.class, () -> charToIntegerInputMapper.mapCharToInteger('-'));
    }

    @Test
    void testMapCharToInteger() {
        //Given
        CharToIntegerInputMapper charToIntegerInputMapper = new CharToIntegerInputMapper();

        //When
        int x = charToIntegerInputMapper.mapCharToInteger('9');

        //Then
        assertEquals(9, x);
    }
}