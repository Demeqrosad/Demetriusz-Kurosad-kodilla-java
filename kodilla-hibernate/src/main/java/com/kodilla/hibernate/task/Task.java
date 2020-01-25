package com.kodilla.hibernate.task;

import com.kodilla.hibernate.tasklist.TaskList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NamedQueries({
        @NamedQuery(
                name = "Task.retrieveLongTasks",
                query = "FROM Task WHERE taskDuration > 10"
        ),
        @NamedQuery(
                name = "Task.retrieveShortTasks",
                query = "FROM Task WHERE taskDuration <= 10"
        ),
        @NamedQuery(
                name = "Task.retrieveTasksWithDurationLongerThan",
                query = "FROM Task WHERE taskDuration > :DURATION"
        )
})
@NamedNativeQuery(
        name = "Task.retrieveTasksWithEnoughTime",
        query = "SELECT * FROM Tasks" +
        " WHERE DATEDIFF(DATE_ADD(taskCreatedDate, INTERVAL taskDuration DAY), NOW()) > 5",
        resultClass = Task.class
)

@Entity
@Table(name = "Tasks")
public class Task
{
    private int taskID;
    private String taskDescription;
    private Date taskCreatedDate;
    private int taskDuration;
    private TaskFinancialDetails taskFinancialDetails;
    private TaskList taskList;

    @ManyToOne
    @JoinColumn(name = "taskListID")
    public TaskList getTaskList()
    {
        return this.taskList;
    }

    public void setTaskList(TaskList taskList)
    {
        this.taskList = taskList;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "financialDetailsID")
    public TaskFinancialDetails getTaskFinancialDetails()
    {
        return this.taskFinancialDetails;
    }

    public void setTaskFinancialDetails(TaskFinancialDetails taskFinancialDetails)
    {
        this.taskFinancialDetails = taskFinancialDetails;
    }

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

    public void setTaskID(int taskID)
    {
        this.taskID = taskID;
    }

    public void setTaskDescription(String taskDescription)
    {
        this.taskDescription = taskDescription;
    }

    public void setTaskCreatedDate(Date taskCreatedDate)
    {
        this.taskCreatedDate = taskCreatedDate;
    }

    public void setTaskDuration(int taskDuration)
    {
        this.taskDuration = taskDuration;
    }
}
