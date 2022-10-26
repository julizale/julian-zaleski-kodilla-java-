package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    @Test
    void testgetLastLog() {
        //Given
        Logger logger = Logger.INSTANCE;

        //When
        logger.log("This is test log.");
        String theLog = logger.getLastLog();

        //Then
        assertEquals("This is test log.", theLog);
    }
}
