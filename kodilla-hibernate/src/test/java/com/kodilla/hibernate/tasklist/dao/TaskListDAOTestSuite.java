package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDAOTestSuite
{
    @Autowired
    private TaskListDAO taskListDAO;

    @Test
    public void testFindByTaskListName()
    {
        //Given
        TaskList toDo = new TaskList("ToDo", "Tasks to be done");
        taskListDAO.save(toDo);
        TaskList inProgress = new TaskList("InProgress", "Tasks in progress");
        taskListDAO.save(inProgress);
        TaskList done = new TaskList("Done", "Tasks being done");
        taskListDAO.save(done);
        //When
        List<TaskList> actTaskListsDone = taskListDAO.findByTaskListName("Done");
        //Then
        Assert.assertEquals(1, actTaskListsDone.size());
        Assert.assertEquals("Tasks being done", actTaskListsDone.get(0).getTaskListDescription());
        //CleanUp
        taskListDAO.deleteById(toDo.getTaskListID());
        taskListDAO.deleteById(inProgress.getTaskListID());
        taskListDAO.deleteById(done.getTaskListID());
    }

    @Test
    public void testFindByTaskListNameContaining()
    {
        //Given
        TaskList toDo = new TaskList("ToDo", "Tasks to be done");
        taskListDAO.save(toDo);
        TaskList inProgress = new TaskList("InProgress", "Tasks in progress");
        taskListDAO.save(inProgress);
        TaskList done = new TaskList("Done", "Tasks being done");
        taskListDAO.save(done);
        //When
        List<TaskList> actTaskListsWithE = taskListDAO.findByTaskListNameContaining("e");
        //Then
        Assert.assertEquals(2, actTaskListsWithE.size());
        //CleanUp
        taskListDAO.deleteById(toDo.getTaskListID());
        taskListDAO.deleteById(inProgress.getTaskListID());
        taskListDAO.deleteById(done.getTaskListID());
    }
}
