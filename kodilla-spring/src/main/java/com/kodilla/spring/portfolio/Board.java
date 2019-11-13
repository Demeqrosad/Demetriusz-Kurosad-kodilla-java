package com.kodilla.spring.portfolio;

public final class Board
{
    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public Board(final TaskList toDoList, final TaskList inProgressList, final TaskList doneList)
    {
        this.doneList = new TaskList();
        this.inProgressList = new TaskList();
        this.toDoList = new TaskList();

    }
    public TaskList getToDoList()
    {
        return this.toDoList;
    }

    public TaskList getInProgressList()
    {
        return this.inProgressList;
    }

    public TaskList getDoneList()
    {
        return this.doneList;
    }
}
