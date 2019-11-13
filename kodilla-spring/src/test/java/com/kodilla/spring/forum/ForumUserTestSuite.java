package com.kodilla.spring.forum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ForumUserTestSuite
{
    @Test
    public void testGetUserName()
    {
        //Given
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("com.kodilla.spring.forum");
        ForumUser forumUser = applicationContext.getBean(ForumUser.class);
        String expResult = "John Smith";
        System.out.println("Expected = " + expResult);
        //When
        String actResult = forumUser.getUsername();
        System.out.println("Actual = " + actResult);
        //Then
        Assert.assertEquals(expResult,actResult);
        System.out.println("TestResult = " + actResult.equals(expResult));
    }
}
