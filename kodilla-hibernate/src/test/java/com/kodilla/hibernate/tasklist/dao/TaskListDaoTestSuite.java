package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    TaskListDao taskListDao;

    private static final String TESTLISTNAME = "Test List Name";

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(TESTLISTNAME, "some description");
        taskListDao.save(taskList);

        //When
        List<TaskList> taskListsFoundByListName = taskListDao.findByListName(TESTLISTNAME);

        //Then
        assertEquals(1, taskListsFoundByListName.size());

        //Clean up
        int id = taskListsFoundByListName.get(0).getId();
        taskListDao.deleteById(id);
    }
}
