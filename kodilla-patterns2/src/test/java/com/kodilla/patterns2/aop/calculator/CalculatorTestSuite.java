package com.kodilla.patterns2.aop.calculator;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorTestSuite {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CalculatorTestSuite.class);

    @Autowired
    private Calculator calculator;

    @Test
    void testAdd() {
        //Given
        //When
        double result = calculator.add(10, 15);
        //Then
        LOGGER.info("Testing add method");
        assertEquals(25, result, 0);
    }
    @Test
    void testSub() {
        //Given
        //When
        double result = calculator.sub(10, 15);
        //Then
        LOGGER.info("Testing sub method");
        assertEquals(-5, result, 0);
    }
    @Test
    void testMul() {
        //Given
        //When
        double result = calculator.mul(10, 15);
        //Then
        LOGGER.info("Testing mul method");
        assertEquals(150, result, 0);
    }
    @Test
    void testDiv() {
        //Given
        //When
        double result = calculator.div(15, 5);
        //Then
        LOGGER.info("Testing div method");
        assertEquals(3, result, 0);
    }

    @Test
    void testFactorial5() {
        //Given
        //When
        BigDecimal result = calculator.factorial(5);
        System.out.println(result);
        //Then
        LOGGER.info("Testing factorial method");
        assertEquals(new BigDecimal(120), result);
    }

    @Test
    void testFactorial6() {
        //Given
        //When
        BigDecimal result = calculator.factorial(6);
        System.out.println(result);
        //Then
        LOGGER.info("Testing factorial method");
        assertEquals(new BigDecimal(720), result);
    }

    @Test
    void testFactorial1() {
        //Given
        //When
        BigDecimal result = calculator.factorial(1);
        System.out.println(result);
        //Then
        LOGGER.info("Testing factorial method");
        assertEquals(BigDecimal.ONE, result);
    }

    @Test
    void testFactorial0() {
        //Given
        //When
        BigDecimal result = calculator.factorial(0);
        System.out.println(result);
        //Then
        LOGGER.info("Testing factorial method");
        assertEquals(BigDecimal.ONE, result);
    }
}
