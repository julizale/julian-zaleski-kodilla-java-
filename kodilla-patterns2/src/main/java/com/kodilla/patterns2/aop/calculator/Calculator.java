package com.kodilla.patterns2.aop.calculator;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@EnableAspectJAutoProxy
public class Calculator {

    public double add(double x, double y) {
        return x + y;
    }
    public double sub(double x, double y) {
        return x - y;
    }
    public double mul(double x, double y) {
        return x * y;
    }
    public double div(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Divide by zero!");
        }
        return x / y;
    }

    public BigDecimal factorial (int n) {
        if (n == 0) {
            return BigDecimal.ONE;
        }
        if (n < 0) {
            throw new ArithmeticException("Argument for factorial() < 0");
        }
        return factorial(n - 1).multiply(new BigDecimal(n));
    }
}
