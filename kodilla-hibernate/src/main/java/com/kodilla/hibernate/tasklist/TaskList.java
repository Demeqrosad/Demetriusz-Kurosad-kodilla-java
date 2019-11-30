package com.kodilla.hibernate.tasklist;

import com.kodilla.hibernate.task.Task;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TaskLists")
@Access(AccessType.PROPERTY)
public class TaskList
{
    private int taskListID;
    private String taskListName;
    private String taskListDescription;
    private List<Task> tasks = new ArrayList<>();

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

    @OneToMany(
            targetEntity = Task.class,
            mappedBy = "taskList",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public List<Task> getTasks()
    {
        return this.tasks;
    }

    private void setTasks(List<Task> tasks)
    {
        this.tasks = tasks;
    }
}
