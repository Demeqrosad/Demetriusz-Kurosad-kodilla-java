package com.kodilla.patterns.factory.tasks;

public final class PaintingTask implements Task
{
    private final String taskName;
    private final String color;
    private final String whatToPaint;

    public PaintingTask(final String taskName, final String color, final String whatToPaint)
    {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
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

    public String getWhatToPaint()
    {
        return this.whatToPaint;
    }

    public String getColor()
    {
        return this.color;
    }

    @Override
    public String toString()
    {
        return this.getClass() + "{" +
                this.getTaskName() + '}';
    }
}
