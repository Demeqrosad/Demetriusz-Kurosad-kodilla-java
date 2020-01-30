package com.kodilla.hibernate.manytomany.facade;

import java.util.ArrayList;
import java.util.List;

public final class EmployeeDTO
{
    private final int employeeID;
    private final String firstName;
    private final String lastName;
    private final List<CompanyDTO> companies = new ArrayList<>();

    public EmployeeDTO(final int employeeID, final String firstName, final String lastName)
    {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public int getEmployeeID()
    {
        return this.employeeID;
    }

    public List<CompanyDTO> getCompanies()
    {
        return this.companies;
    }
}
