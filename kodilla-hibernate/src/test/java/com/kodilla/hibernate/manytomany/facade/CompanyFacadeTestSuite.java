package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CompanyFacadeTestSuite {

    @Autowired
    private CompanyFacade companyFacade;
    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testRetrieveCompaniesWithNamesContaining() {
        //Given
        Company dataMasters = new Company("Data Masters");
        companyDao.save(dataMasters);
        int id2 = dataMasters.getId();
        Company softwareMachine = new Company("Software Machine");
        companyDao.save(softwareMachine);
        int id1 = softwareMachine.getId();
        Company dataBulldog = new Company("Data Bulldog");
        companyDao.save(dataBulldog);
        int id3 = dataBulldog.getId();

        //When
        List<Company> companiesWithNamesContaining1 = companyFacade.getCompaniesWithNamesContaining("Data");
        List<Company> companiesWithNamesContaining2 = companyFacade.getCompaniesWithNamesContaining("chin");
        List<Company> companiesWithNamesContaining3 = companyFacade.getCompaniesWithNamesContaining(" Masters");

        //Then
        try {
            assertEquals(2, companiesWithNamesContaining1.size());
            assertEquals(1, companiesWithNamesContaining2.size());
            assertEquals(1, companiesWithNamesContaining3.size());
        } finally {
            //CleanUp
            companyDao.deleteById(id1);
            companyDao.deleteById(id2);
            companyDao.deleteById(id3);
        }
    }

    @Test
    void testRetrieveEmployeesWithLastname() {
        //Given
        Employee employee1 = new Employee("John", "Smith");
        employeeDao.save(employee1);
        int id1 = employee1.getId();
        Employee employee2 = new Employee("Stephanie", "Johnson");
        employeeDao.save(employee2);
        int id2 = employee2.getId();
        Employee employee3 = new Employee("Amanda", "Smith");
        employeeDao.save(employee3);
        int id3 = employee3.getId();

        //When
        List<Employee> employeeList1 = companyFacade.getEmployeesWithNamesContaining("mith");
        List<Employee> employeeList2 = companyFacade.getEmployeesWithNamesContaining("John");
        List<Employee> employeeList3 = companyFacade.getEmployeesWithNamesContaining("rurir");

        //Then
        assertEquals(2, employeeList1.size());
        assertEquals(2, employeeList2.size());
        assertEquals(new ArrayList<>(), employeeList3);

        //CleanUp
        try {
            employeeDao.deleteById(id1);
            employeeDao.deleteById(id2);
            employeeDao.deleteById(id3);
        } catch (Exception e) {
            //do nothing
        }
    }
}
