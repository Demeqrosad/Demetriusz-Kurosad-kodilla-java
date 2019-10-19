package com.kodilla.testing.shape;

public class Square implements Shape
{
    final private double squareBase;

    public Square(double squareBase)
    {
        this.squareBase = squareBase;
    }

    @Override
    public String getShapeName()
    {
        return "Square";
    }
    @Override
    public double getField()
    {
        return this.squareBase * this.squareBase;
    }
}
