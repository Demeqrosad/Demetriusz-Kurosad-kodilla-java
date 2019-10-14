package com.kodilla.testing.shape;

import org.junit.Assert;
import org.junit.Test;

public class ShapeCollectorTestSuite
{
    @Test
    public void testCaseAddFigure()
    {
        //Given
        ShapeCollector testCollector = new ShapeCollector();
        Shape myShape = new Triangle(3,4);
        boolean expResult = true;
        boolean actResult;
        //When
        actResult = testCollector.addFigure(myShape);
        actResult = actResult && testCollector.getCollection().size()==1;
        System.out.println("Test case addFigure with "+ expResult
                + " as expected and " + actResult + " as actual output");
        //Then
        Assert.assertTrue(expResult == actResult);
    }
    @Test
    public void testCaseShowFigures()
    {
        //Given
        ShapeCollector testCollector = new ShapeCollector();
        Shape myShape1 = new Triangle(3,4);
        Shape myShape2 = new Square(5);
        testCollector.addFigure(myShape1);
        testCollector.addFigure(myShape2);
        String expResult = "(" + myShape1.getShapeName() + " of area "
                + myShape1.getField() + ")" + "\n(" + myShape2.getShapeName()
                + " of area " + myShape2.getField() + ")";
        String actResult;
        //When
        actResult = testCollector.showFigures();
        System.out.println("Test case showFigure with\n"+ expResult
                + "\nas expected and\n" + actResult + "\nas actual output");
        //Then
        Assert.assertEquals(expResult, actResult);
    }
    @Test
    public void testCaseGetFigure()
    {
        //Given
        ShapeCollector testCollector = new ShapeCollector();
        Shape myShape = new Triangle(3,4);
        Shape expResult = myShape;
        Shape actResult;
        //When
        testCollector.addFigure(myShape);
        actResult = testCollector.getFigure(0);
        System.out.println("Test case getFigure with "+ expResult
                + " as expected and " + actResult + " as actual output");
        //Then
        Assert.assertEquals(expResult,actResult);
    }
    @Test
    public void testCaseRemoveFigure()
    {
        //Given
        ShapeCollector testCollector = new ShapeCollector();
        Shape myShape = new Triangle(3,4);
        boolean expResult = true;
        boolean actResult;
        //When
        testCollector.addFigure(myShape);
        actResult = testCollector.removeFigure(testCollector.getFigure(0));
        actResult = actResult && testCollector.getCollection().size()==0;
        System.out.println("Test case removeFigure with "+ expResult
                + " as expected and " + actResult + " as actual output");
        //Then
        Assert.assertTrue(expResult == actResult);
    }
}
