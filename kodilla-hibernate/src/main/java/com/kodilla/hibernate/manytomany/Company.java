package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQuery(
        name = "Company.retrieveBy3LettersOfName",
        query = "SELECT * FROM Companies" +
                " WHERE LEFT(companyName, 3) = :BEGINNING",
        resultClass = Company.class
)

@Entity
@Table(name = "Companies")
public class Company
{
    private int companyID;
    private String companyName;
    private List<Employee> employees = new ArrayList<>();

    public Company()
    {
    }

    public Company(String companyName)
    {
        this.companyName = companyName;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "companyID")
    public int getCompanyID()
    {
        return this.companyID;
    }

    @NotNull
    @Column(name = "companyName")
    public String getCompanyName()
    {
        return this.companyName;
    }

    private void setCompanyID(int companyID)
    {
        this.companyID = companyID;
    }

    private void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees()
    {
        return this.employees;
    }

    private void setEmployees(List<Employee> employees)
    {
        this.employees = employees;
    }
}
