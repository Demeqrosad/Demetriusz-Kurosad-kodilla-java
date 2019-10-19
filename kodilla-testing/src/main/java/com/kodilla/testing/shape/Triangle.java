package com.kodilla.testing.shape;

public class Triangle implements Shape
{
    final private double triangleBase;
    final private double triangleHeight;

    public Triangle(double triangleBase, double triangleHeight)
    {
        this.triangleBase = triangleBase;
        this.triangleHeight = triangleHeight;
    }

    @Override
    public String getShapeName()
    {
        return "Triangle";
    }
    @Override
    public double getField()
    {
        return this.triangleBase * this.triangleHeight / 2;
    }
}
