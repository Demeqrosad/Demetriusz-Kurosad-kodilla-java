package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator
{
    public static ArrayList<Integer> exterminate(ArrayList<Integer> numbers)
    {
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for (Integer myNumber: numbers)
        {
            if (isEven(myNumber))
            {
                newList.add(myNumber);
            }
        }
        return newList;
    }

    public static boolean isEven(int number)
    {
        return (number%2 == 0);
    }
}
