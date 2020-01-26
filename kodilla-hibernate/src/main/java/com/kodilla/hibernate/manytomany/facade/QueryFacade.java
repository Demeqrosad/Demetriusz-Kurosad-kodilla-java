package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class QueryFacade
{
    @Autowired
    private ResponseMapper responseMapper;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    public List<CompanyDTO> findCompaniesWithNameContains(String contains)
    {
        return responseMapper.mapToCompanyDTOList(
                companyDao.retrieveByAnyPartOfName("%" + contains + "%")
        );
    }

    public List<EmployeeDTO> findEmployeesWithNameContains(String contains)
    {
        return responseMapper.mapToEmployeeDTOList(
                employeeDao.retrieveByAnyPartOfName("%" + contains + "%")
        );
    }
}
