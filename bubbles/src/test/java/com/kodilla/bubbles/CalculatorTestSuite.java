package com.kodilla.bubbles;

import com.kodilla.bubbles.exception.NotNumericCharacterException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTestSuite {

    @Test
    void testCalculatorFindSecondMin() {
        //Given
        int[] intArray = new int[]{ 3,1,1,5,6,7,9,15,3,4,7,10 };
        Calculator calculator = new Calculator();

        //When
        int secondMin = calculator.findSecondMin(intArray);

        //Then
        assertEquals(3, secondMin);
    }

    @Test
    void testCalculatorFindSecondMax() {
        //Given
        int[] intArray = new int[]{ 3,1,1,5,6,7,9,15,3,4,7,10 };
        Calculator calculator = new Calculator();

        //When
        int secondMax = calculator.findSecondMax(intArray);

        //Then
        assertEquals(10, secondMax);
    }

    @Test
    void testMapStringToInt() throws NotNumericCharacterException {
        //Given
        Calculator calculator = new Calculator();
        //When
        int number1 = calculator.mapStringToInt("0");
        int number2 = calculator.mapStringToInt("1200");
        int number3 = calculator.mapStringToInt("89");
        int number4 = calculator.mapStringToInt("2");
        //Then
        assertEquals(0, number1);
        assertEquals(1200, number2);
        assertEquals(89, number3);
        assertEquals(2, number4);
    }

    @Test
    void testMapStringToIntThrowsException() throws NotNumericCharacterException {
        //Given
        Calculator calculator = new Calculator();
        //When & Then
        assertThrows(NotNumericCharacterException.class, () -> calculator.mapStringToInt("-3"));
        assertThrows(NotNumericCharacterException.class, () -> calculator.mapStringToInt("12%8"));
        assertThrows(NotNumericCharacterException.class, () -> calculator.mapStringToInt("000AWs"));
    }

    @Test
    void testMapDecToBin() {
        //Given
        Calculator calculator = new Calculator();
        //When
        String bin1 = calculator.mapDecToBin(5);
        System.out.println(bin1);
        String bin2 = calculator.mapDecToBin(-128);
        System.out.println(bin2);
        String bin3 = calculator.mapDecToBin(95);
        System.out.println(bin3);
        String bin4 = calculator.mapDecToBin(0);
        System.out.println(bin4);
        //Then
        assertEquals("101", bin1);
        assertEquals("-10000000", bin2);
        assertEquals("1011111", bin3);
        assertEquals("0", bin4);
    }

    @Test
    void testMapDecToHex() {
        //Given
        Calculator calculator = new Calculator();
        //When
        String hex1 = calculator.mapDecToHex(5);
        System.out.println(hex1);
        String hex2 = calculator.mapDecToHex(12810);
        System.out.println(hex2);
        String hex3 = calculator.mapDecToHex(-43);
        System.out.println(hex3);
        String hex4 = calculator.mapDecToHex(0);
        System.out.println(hex4);
        //Then
        assertEquals("5", hex1);
        assertEquals("320A", hex2);
        assertEquals("-2B", hex3);
        assertEquals("0", hex4);
    }
}
