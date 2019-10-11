package com.kodilla.testing.collection;

import org.junit.*;
import java.util.ArrayList;

public class CollectionTestSuite
{
    private static int i = 0;
    private static String[] myInfo =
    {
            "Test of method exterminate with empty list ",
            "Test of method exterminate with normal list "
    };
    @Before
    public void before()
    {
        System.out.println(myInfo[i] + "has started");
    }
    @After
    public void after()    {
        System.out.println(myInfo[i] + "has ended");
        i++;
    }
    @Test
    public void testOddNumbersExterminatorEmptyList()
    {
        //Given
        ArrayList<Integer> emptyList = new ArrayList<Integer>();
        System.out.println("List IN: " + emptyList);
        //When
        ArrayList<Integer> newList = OddNumbersExterminator.exterminate(emptyList);
        System.out.println("List OUT: " + newList);
        //Then
        Assert.assertEquals(emptyList, newList);
    }
    @Test
    public void testOddNumbersExterminatorNormalList()
    {
        //Given
        ArrayList<Integer> normalList = new ArrayList<Integer>();
        normalList.add(2);
        normalList.add(4);
        normalList.add(3);
        normalList.add(5);
        System.out.println("List IN: " + normalList);
        //When
        ArrayList<Integer> newList = OddNumbersExterminator.exterminate(normalList);
        System.out.println("List OUT: " + newList);
        //Then
        Assert.assertEquals(normalList.subList(0,2), newList);
    }
}
