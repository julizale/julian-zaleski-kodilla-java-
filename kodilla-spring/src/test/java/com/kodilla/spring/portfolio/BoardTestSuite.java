package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.getToDoList().getTasks().add("Task to do.");
        board.getInProgressList().getTasks().add("Task in progress.");
        board.getDoneList().getTasks().add("Task done.");

        //Then
        assertEquals("Task to do.", board.getToDoList().getTasks().get(0));
        assertEquals("Task in progress.", board.getInProgressList().getTasks().get(0));
        assertEquals("Task done.", board.getDoneList().getTasks().get(0));
    }

    @Test
    void testTaskAdd2() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.getToDoList().getTasks().add("Task to do.");
        board.getInProgressList().getTasks().add("Task in progress.");
        board.getDoneList().getTasks().add("Task done.");
        TaskList toDoList = (TaskList)context.getBean("toDoList");
        TaskList inProgressList = (TaskList)context.getBean("inProgressList");
        TaskList doneList = (TaskList)context.getBean("doneList");
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

        //Then
        assertEquals("Task to do.", toDoList.getTasks().get(0));
    }
}

