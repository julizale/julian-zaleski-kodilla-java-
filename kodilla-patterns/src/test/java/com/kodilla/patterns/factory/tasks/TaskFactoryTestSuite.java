package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testDriving() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task driving = factory.makeTask(TaskFactory.DRIVING);
        boolean beforeExecution = driving.isTaskExecuted();
        driving.executeTask();
        boolean afterExecution = driving.isTaskExecuted();

        //Then
        assertEquals("Driving home", driving.getTaskName());
        assertFalse(beforeExecution);
        assertTrue(afterExecution);
    }

    @Test
    void testShopping() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task shopping = factory.makeTask(TaskFactory.SHOPPING);
        boolean beforeExecution = shopping.isTaskExecuted();
        shopping.executeTask();
        boolean afterExecution = shopping.isTaskExecuted();

        //Then
        assertEquals("Shopping eggs", shopping.getTaskName());
        assertFalse(beforeExecution);
        assertTrue(afterExecution);
    }

    @Test
    void testPainting() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task painting = factory.makeTask(TaskFactory.PAINTING);
        boolean beforeExecution = painting.isTaskExecuted();
        painting.executeTask();
        boolean afterExecution = painting.isTaskExecuted();

        //Then
        assertEquals("Painting wall", painting.getTaskName());
        assertFalse(beforeExecution);
        assertTrue(afterExecution);
    }
}
