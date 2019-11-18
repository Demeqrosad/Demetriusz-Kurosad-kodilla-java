package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task
{
    private final String taskName;
    private final String where;
    private final String using;

    public DrivingTask(final String taskName, final String where, final String using)
    {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
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

    public String getWhere()
    {
        return this.where;
    }

    public String getUsing()
    {
        return this.using;
    }

    @Override
    public String toString()
    {
        return this.getClass() + "{" +
                this.getTaskName() + '}';
    }
}
