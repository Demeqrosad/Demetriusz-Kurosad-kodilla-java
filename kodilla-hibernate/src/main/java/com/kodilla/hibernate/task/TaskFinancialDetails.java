package com.kodilla.hibernate.task;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "TasksFinancials")
public class TaskFinancialDetails
{
    private int financialDetailsID;
    private BigDecimal taskPrice;
    private boolean taskPaid;

    public TaskFinancialDetails()
    {
    }

    public TaskFinancialDetails(BigDecimal taskPrice, boolean taskPaid)
    {
        this.taskPrice = taskPrice;
        this.taskPaid = taskPaid;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "financialDetailsID", unique = true)
    public int getFinancialDetailsID()
    {
        return this.financialDetailsID;
    }

    @Column(name = "taskPrice")
    public BigDecimal getTaskPrice()
    {
        return this.taskPrice;
    }

    @Column(name = "taskPaid")
    public boolean isTaskPaid()
    {
        return this.taskPaid;
    }

    private void setFinancialDetailsID(int financialDetailsID)
    {
        this.financialDetailsID = financialDetailsID;
    }

    private void setTaskPrice(BigDecimal taskPrice)
    {
        this.taskPrice = taskPrice;
    }

    private void setTaskPaid(boolean taskPaid)
    {
        this.taskPaid = taskPaid;
    }
}
