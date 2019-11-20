package com.kodilla.patterns.factory.tasks;

public final class TaskFactory
{
    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";

    public final Task createTask(final String taskClass)
    {
        switch (taskClass)
        {
            case DRIVING:
                return new DrivingTask("Go to nearest shop", "BigBuilder", "van");
            case SHOPPING:
                return new ShoppingTask("Buy needed materials", "Painting materials", 1);
            case PAINTING:
                return new PaintingTask("Refresh apartment", "grey", "living room");
            default:
                return null;
        }
    }
}
