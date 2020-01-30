package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryFacadeTestSuite
{
    @Autowired
    private CompanyDao companyDAO;

    @Autowired
    private EmployeeDao employeeDAO;

    @Autowired
    private QueryFacade queryFacade;

    @Test
    public void testFindCompaniesWithNameContains()
    {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        companyDAO.save(softwareMachine);
        int softwareMachineId = softwareMachine.getCompanyID();
        companyDAO.save(dataMaesters);
        int dataMaestersId = dataMaesters.getCompanyID();
        companyDAO.save(greyMatter);
        int greyMatterId = greyMatter.getCompanyID();
        //When
        List<CompanyDTO> resultCompanies = queryFacade.findCompaniesWithNameContains("ter");

        //Then
        Assert.assertEquals(2, resultCompanies.size());

        //CleanUp
        try
        {
            companyDAO.deleteById(softwareMachineId);
            companyDAO.deleteById(dataMaestersId);
            companyDAO.deleteById(greyMatterId);
        }
        catch (Exception e)
        {
            //do nothing
        }
    }

    @Test
    public void testFindEmployeesWithNameContains()
    {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        companyDAO.save(softwareMachine);
        int softwareMachineId = softwareMachine.getCompanyID();
        companyDAO.save(dataMaesters);
        int dataMaestersId = dataMaesters.getCompanyID();
        companyDAO.save(greyMatter);
        int greyMatterId = greyMatter.getCompanyID();
        //When
        List<EmployeeDTO> resultEmployees = queryFacade.findEmployeesWithNameContains("l");

        //Then
        Assert.assertEquals(2, resultEmployees.size());

        //CleanUp
        try
        {
            companyDAO.deleteById(softwareMachineId);
            companyDAO.deleteById(dataMaestersId);
            companyDAO.deleteById(greyMatterId);
        }
        catch (Exception e)
        {
            //do nothing
        }
    }

}