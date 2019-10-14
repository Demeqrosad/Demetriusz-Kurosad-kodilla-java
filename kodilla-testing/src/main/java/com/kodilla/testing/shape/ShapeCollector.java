package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector
{
    private ArrayList<Shape> collection = new ArrayList<Shape>();

    public boolean addFigure(Shape shape)
    {
        this.collection.add(shape);
        if(this.collection.contains(shape))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean removeFigure(Shape shape)
    {
        if (this.collection.contains(shape))
        {
            this.collection.remove(shape);
            return true;
        }
        else
        {
            return false;
        }
    }
    public Shape getFigure(int n)
    {
        return this.collection.get(n);
    }
    public String showFigures()
    {
        String result = "";
        if(this.collection.size()==0)
        {
            return "Collection is empty";
        }
        else
        {
            for(int i=0; i<this.collection.size();i++)
            {
                if(i==0)
                {
                    result = result + "(" + this.collection.get(i).getShapeName()
                            + " of area " + this.collection.get(i).getField() + ")";
                }
                else
                {
                    result = result + "\n(" + this.collection.get(i).getShapeName()
                            + " of area " + this.collection.get(i).getField() + ")";
                }
            }
            return result;
        }
    }
    //Additional getter
    public ArrayList<Shape> getCollection()
    {
        return this.collection;
    }
}
