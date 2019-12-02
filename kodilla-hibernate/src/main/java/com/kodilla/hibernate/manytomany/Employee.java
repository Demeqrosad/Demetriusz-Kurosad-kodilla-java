package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Employees")
public class Employee
{
    private int employeeID;
    private String firstName;
    private String lastName;
    private List<Company> companies = new ArrayList<>();

    public Employee()
    {
    }

    public Employee(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "employeeID")
    public int getEmployeeID()
    {
        return this.employeeID;
    }

    @NotNull
    @Column(name = "firsName")
    public String getFirstName()
    {
        return this.firstName;
    }

    @NotNull
    @Column(name = "lastName")
    public String getLastName()
    {
        return this.lastName;
    }

    private void setEmployeeID(int employeeID)
    {
        this.employeeID = employeeID;
    }

    private void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    private void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JoinCompanyEmployee",
            joinColumns = {@JoinColumn(name = "employeeID", referencedColumnName = "employeeID")},
            inverseJoinColumns = {@JoinColumn(name = "companyID", referencedColumnName = "companyID")}
    )
    public List<Company> getCompanies()
    {
        return this.companies;
    }

    private void setCompanies(List<Company> companies)
    {
        this.companies = companies;
    }
}
