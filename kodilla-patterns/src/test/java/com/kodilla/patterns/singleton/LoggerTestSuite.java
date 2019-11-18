package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite
{
    @Test
    public void testGetLastLog()
    {
        //Given
        String expResult = "Testing our app";
        //When
        Logger.getInstance().log(expResult);
        String actResult = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals(expResult, actResult);
    }

    @Test
    public void testInstanceOfLogger()
    {
        //Given
        Logger logger1;
        Logger logger2;
        //When
        System.out.println(Logger.getInstanceOfLogger());
        logger1 = Logger.getInstance();
        System.out.println(Logger.getInstanceOfLogger());
        logger2 = Logger.getInstance();
        System.out.println(Logger.getInstanceOfLogger());
        //Then
        Assert.assertTrue(logger1.equals(logger2));
    }
}
