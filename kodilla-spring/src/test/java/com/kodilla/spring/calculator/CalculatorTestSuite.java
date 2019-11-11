package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite
{
    @Test
    public void testCalculations()
    {
        //Given
        double a = 12;
        double b = 4;
        ApplicationContext contex =
                new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator calculator = contex.getBean(Calculator.class);
        double expResultAdd = 16;
        double expResultSub = 8;
        double expResultMul = 48;
        double expResultDiv = 3;
        //When
        double actResultAdd = calculator.add(a,b);
        double actResultSub = calculator.sub(a,b);
        double actResultMul = calculator.mul(a,b);
        double actResultDiv = calculator.div(a,b);
        //Then
        Assert.assertEquals(expResultAdd, actResultAdd, 0.0);
        Assert.assertEquals(expResultSub, actResultSub, 0.0);
        Assert.assertEquals(expResultMul, actResultMul, 0.0);
        Assert.assertEquals(expResultDiv, actResultDiv, 0.0);
    }
}
