package com.kodilla.good.patterns.food2door;

public class ObjectCreator
{
    public static Object create(String className)
    {
        Object resultObject = null;
        try
        {
            Class classToCreate = Class.forName(className);
            resultObject = classToCreate.newInstance();
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException e)
        {
            System.out.println(e);
        }
        return resultObject;
    }
}
