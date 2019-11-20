package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite
{
    @Test
    public void testCreateTask()
    {
        //Given
        TaskFactory factory = new TaskFactory();
        String expResult1 = "Go to nearest shop";
        String expResult2 = "Buy needed materials";
        String expResult3 = "Refresh apartment";
        //When
        String actResult1 = factory.createTask(TaskFactory.DRIVING).getTaskName();
        String actResult2 = factory.createTask(TaskFactory.SHOPPING).getTaskName();
        String actResult3 = factory.createTask(TaskFactory.PAINTING).getTaskName();
        //Then
        Assert.assertEquals(expResult1, actResult1);
        Assert.assertEquals(expResult2, actResult2);
        Assert.assertEquals(expResult3, actResult3);
    }
    @Test
    public void testTaskStatus()
    {
        //Given
        Task shopping = new PaintingTask("name", "to do", "1");
        Task purchase = new DrivingTask("name2", "to do2", "car");
        //When
        boolean actResultInitial = TasksStatus.check(shopping);
        shopping.executeTask();
        purchase.executeTask();
        boolean actResultFinal = TasksStatus.check(shopping);
        //Then
        Assert.assertTrue(actResultFinal);
        Assert.assertFalse(actResultInitial);
        Assert.assertEquals(2, TasksStatus.getExecuted().size());
    }
}
