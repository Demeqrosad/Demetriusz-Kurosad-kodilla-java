package com.kodilla.hibernate.tasklist;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TaskLists")
@Access(AccessType.PROPERTY)
public class TaskList
{
    private int taskListID;
    private String taskListName;
    private String taskListDescription;

    public TaskList()
    {
    }

    public TaskList(String taskListName, String taskListDescription)
    {
        this.taskListName = taskListName;
        this.taskListDescription = taskListDescription;
    }
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "taskListID", unique = true)
    public int getTaskListID()
    {
        return this.taskListID;
    }

    public void setTaskListID(int taskListID)
    {
        this.taskListID = taskListID;
    }

    @Column(name = "taskListName")
    public String getTaskListName()
    {
        return this.taskListName;
    }

    public void setTaskListName(String taskListName)
    {
        this.taskListName = taskListName;
    }

    @Column(name = "taskListDescription")
    public String getTaskListDescription()
    {
        return this.taskListDescription;
    }

    public void setTaskListDescription(String taskDescription)
    {
        this.taskListDescription = taskDescription;
    }
}
