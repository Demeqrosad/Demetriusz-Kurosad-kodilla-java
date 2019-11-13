package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite
{
    @Test
    public void testTaskAdd()
    {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.portfolio");
        Board board = context.getBean(Board.class);
        String expResultToDo = "Do yesterday's task";
        String expResultInProgress = "Postpone yesterday's task for tomorrow";
        String expResultDone = "Postpone today's task for tomorrow";
        //When
        board.getDoneList().addTask(expResultDone);
        board.getInProgressList().addTask(expResultInProgress);
        board.getToDoList().addTask(expResultToDo);
        String actResultToDo = board.getToDoList().getTasks().get(0);
        String actResultInProgress = board.getInProgressList().getTasks().get(0);
        String actResultDone = board.getDoneList().getTasks().get(0);
        //Then
        Assert.assertEquals(expResultToDo, actResultToDo);
        Assert.assertEquals(expResultInProgress, actResultInProgress);
        Assert.assertEquals(expResultDone, actResultDone);
    }
}
