package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.dao.TaskDAO;
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

    @Autowired
    private TaskDAO taskDAO;
    private static String LISTNAME = "ToDo List";

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
    public void testTaskListDaoSaveWithTasks()
    {
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

    @Test
    public void testNamedQueries()
    {
        //Given
        Task task1 = new Task("Test: Study Hibernate", 3);
        Task task2 = new Task("Test: Practice Named Queries", 6);
        Task task3 = new Task("Test: Study native queries", 7);
        Task task4 = new Task("Test: Make some tests", 13);

        TaskFinancialDetails tfd1 = new TaskFinancialDetails(new BigDecimal(5), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        TaskFinancialDetails tfd3 = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd4 = new TaskFinancialDetails(new BigDecimal(15), false);

        task1.setTaskFinancialDetails(tfd1);
        task2.setTaskFinancialDetails(tfd2);
        task3.setTaskFinancialDetails(tfd3);
        task4.setTaskFinancialDetails(tfd4);

        TaskList taskList = new TaskList(LISTNAME, "ToDo tasks");
        taskList.getTasks().add(task1);
        taskList.getTasks().add(task2);
        taskList.getTasks().add(task3);
        taskList.getTasks().add(task4);

        task1.setTaskList(taskList);
        task2.setTaskList(taskList);
        task3.setTaskList(taskList);
        task4.setTaskList(taskList);

        taskListDAO.save(taskList);
        int id = taskList.getTaskListID();

        //When
        List<Task> longTasks = taskDAO.retrieveLongTasks();
        List<Task> shortTasks = taskDAO.retrieveShortTasks();
        List<Task> enoughTimeTasks = taskDAO.retrieveTasksWithEnoughTime();
        List<Task> durationLongerThenTasks = taskDAO.retrieveTasksWithDurationLongerThan(6);

        //Then
        try
        {
            Assert.assertEquals(1, longTasks.size());
            Assert.assertEquals(3, shortTasks.size());
            Assert.assertEquals(3, enoughTimeTasks.size());
            Assert.assertEquals(2, durationLongerThenTasks.size());
        }
        finally
        {
            //CleanUp
            taskListDAO.deleteById(id);
        }
    }
}
