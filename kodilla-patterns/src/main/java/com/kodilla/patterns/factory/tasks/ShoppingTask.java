package com.kodilla.patterns.factory.tasks;

public final class ShoppingTask implements Task
{
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;

    public ShoppingTask(final String taskName, final String whatToBuy, final double quantity)
    {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public void executeTask()
    {
        TasksStatus.execute(this);
    }

    @Override
    public String getTaskName()
    {
        return this.taskName;
    }

    @Override
    public boolean isTaskExecuted()
    {
        return TasksStatus.check(this);
    }

    public String getWhatToBuy()
    {
        return this.whatToBuy;
    }

    public double getQuantity()
    {
        return this.quantity;
    }

    @Override
    public String toString()
    {
        return this.getClass() + "{" +
                this.getTaskName() + '}';
    }
}
