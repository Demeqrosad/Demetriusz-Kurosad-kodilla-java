package com.kodilla.testing.shape;

public class Circle implements Shape
{
    private double circleRadius;

    public Circle(double circleRadius)
    {
        this.circleRadius = circleRadius;
    }

    @Override
    public String getShapeName()
    {
        return "Circle";
    }
    @Override
    public double getField()
    {
        return Math.PI * this.circleRadius * this.circleRadius;
    }
}
