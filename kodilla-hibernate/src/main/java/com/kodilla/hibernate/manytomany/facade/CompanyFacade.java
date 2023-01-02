package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyFacade {

    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    public CompanyFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> getCompaniesWithNamesContaining(String str) {
        return companyDao.retrieveCompaniesWithNamesContaining("%" + str + "%");
    }

    public List<Employee> getEmployeesWithNamesContaining(String str) {
        List<Employee> list1 = employeeDao.retrieveEmployeesWithFirstnamesContaining("%" + str + "%");
        List<Employee> list2 = employeeDao.retrieveEmployeesWithLastnamesContaining("%" + str + "%");
        list1.addAll(list2);
        return list1;
    }
}
