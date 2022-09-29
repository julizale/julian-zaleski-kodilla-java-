package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;
import java.util.*;

@DisplayName("Collection Test Suite")

public class CollectionTestSuite {

    @BeforeEach
    public void beforeCase() {
        System.out.println("Test Case: begin.");
    }

    @AfterEach
    public void afterCase() {
        System.out.println("Test Case: end.\n");
    }

    @DisplayName("When oddNumbersExterminator gets empty list, " +
            "should return empty list")

    @Test
    void oddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        List<Integer> emptyList = new LinkedList<>();
        List<Integer> resultList = oddNumbersExterminator.exterminate(emptyList);
        System.out.println("Testing empty list...");
        //Then
        Assertions.assertIterableEquals(emptyList, resultList, "Error - method doesn't return" +
                " an empty list!");
    }

    @DisplayName("When oddNumbersCalculator gets list containing odd and even numbers," +
            " should return the list containing only odd numbers")

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        List<Integer> testList = Arrays.asList(-4, -1, 0, 2, 7, 12);
        List<Integer> expectedList = Arrays.asList(-4, 0, 2, 12);
        System.out.println("Testing list containing even & odd numbers...");
        //Then
        Assertions.assertIterableEquals(expectedList, oddNumbersExterminator.exterminate(testList),
                "Error! Method exterminate didn't return list containing even numbers!");
    }
}

