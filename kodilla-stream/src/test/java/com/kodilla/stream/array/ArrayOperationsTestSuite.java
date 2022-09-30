package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int[] numbers = new int[6];
        IntStream.range(0, numbers.length)
                .forEach(n -> numbers[n] = n + 3);

        //When
        double average = ArrayOperations.getAverage(numbers);

        //Then
        assertEquals(5.5, average);
    }
}
