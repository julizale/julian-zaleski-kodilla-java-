package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations() {
        //Given & When
        double sum = calculator.add(-3, 4.8);
        double diff = calculator.sub(8.2, 1.3);
        double prod = calculator.mul(2.0, 2.0);
        double quot = calculator.div(4.0, 2.1);

        //Then
        assertEquals(1.7999999999999998, sum);
        assertEquals(6.8999999999999995, diff);
        assertEquals(4.0, prod);
        assertEquals(1.9047619047619047, quot);
        assertThrows(ArithmeticException.class, ()->calculator.div(4, 0));
    }
}
