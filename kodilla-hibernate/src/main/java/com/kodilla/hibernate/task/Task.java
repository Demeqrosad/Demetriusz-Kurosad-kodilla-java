package com.kodilla.hibernate.task;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Tasks")
public class Task
{
    private int taskID;
    private String taskDescription;
    private Date taskCreatedDate;
    private int taskDuration;

    public Task()
    {

    }

    public Task(String taskDescription, int taskDuration)
    {
        this.taskDescription = taskDescription;
        this.taskCreatedDate = new Date();
        this.taskDuration = taskDuration;
    }
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "taskID")
    public int getTaskID()
    {
        return taskID;
    }
    @Column(name = "taskDescription")
    public String getTaskDescription()
    {
        return taskDescription;
    }
    @NotNull
    @Column(name = "taskCreatedDate")
    public Date getTaskCreatedDate()
    {
        return taskCreatedDate;
    }
    @Column(name = "taskDuration")
    public int getTaskDuration()
    {
        return taskDuration;
    }

    private void setTaskID(int taskID)
    {
        this.taskID = taskID;
    }

    private void setTaskDescription(String taskDescription)
    {
        this.taskDescription = taskDescription;
    }

    private void setTaskCreatedDate(Date taskCreatedDate)
    {
        this.taskCreatedDate = taskCreatedDate;
    }

    private void setTaskDuration(int taskDuration)
    {
        this.taskDuration = taskDuration;
    }
}
