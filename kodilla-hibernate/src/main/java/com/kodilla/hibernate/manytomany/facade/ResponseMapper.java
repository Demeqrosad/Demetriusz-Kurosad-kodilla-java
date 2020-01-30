package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResponseMapper
{
    public List<EmployeeDTO> mapToEmployeeDTOList(final List<Employee> employees)
    {
        return employees.stream()
                .map(e -> new EmployeeDTO(e.getEmployeeID(), e.getFirstName(), e.getLastName()))
                .collect(Collectors.toList());
    }

    public List<CompanyDTO> mapToCompanyDTOList(final List<Company> companies)
    {
        return companies.stream()
                .map(c -> new CompanyDTO(c.getCompanyID(), c.getCompanyName()))
                .collect(Collectors.toList());
    }
}
