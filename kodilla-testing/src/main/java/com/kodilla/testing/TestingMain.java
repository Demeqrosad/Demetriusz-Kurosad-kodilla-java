package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args)
    {
        int a = 7;
        int b = 5;
//Test of method Calculator.add
        if (Calculator.add(a,b) == a+b)
        {
            System.out.println("Test of method Calculator.add - OK");
        }
        else
        {
            System.out.println("Error in test of method Calculator.add");
        }
//Test of method Calculator.subtract
        if (Calculator.subtract(a,b) == a-b)
        {
            System.out.println("Test of method Calculator.subtract - OK");
        }
        else
        {
            System.out.println("Error in test of method Calculator.subtract");
        }
    }
}
