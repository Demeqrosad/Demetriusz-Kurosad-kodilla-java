package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
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

    @Test
    public void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList("ToDo", "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        //When
        taskListDAO.save(taskList);
        int id = taskList.getTaskListID();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        taskListDAO.deleteById(id);
    }
}
