package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Employee;

import java.util.ArrayList;
import java.util.List;

public final class CompanyDTO
{
    private final int companyID;
    private final String companyName;
    private final List<EmployeeDTO> employees = new ArrayList<>();

    public CompanyDTO(int companyID, String companyName)
    {
        this.companyID = companyID;
        this.companyName = companyName;
    }

    public String getCompanyName()
    {
        return this.companyName;
    }

    public int getCompanyID()
    {
        return this.companyID;
    }

    public List<EmployeeDTO> getEmployees()
    {
        return this.employees;
    }
}
