package com.kodilla.patterns2.aop.calculator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Watcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(Watcher.class);

    @Before("execution(* *.factorial(..)) && args(number) && target(o)")
    public void logEvent(Calculator o, int number) {
        LOGGER.info("Class: " + o.getClass().getName() + ", Arg: " + number);
    }

    @Around("execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Time consumed " + (end - begin) + "[ms]");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logProcessOrder() {
        LOGGER.info("Processing Order");
    }

    @AfterThrowing(value = "execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))", throwing = "exception")
    public void logProcessOrderThrowing(Exception exception) {
        LOGGER.info("Order processing cancelled: " + exception.getMessage());
    }

    @AfterReturning("execution(* *.processOrder(..))")
    public void logProcessOrderCompleted() {
        LOGGER.info("Order completed successfully.");
    }
}
