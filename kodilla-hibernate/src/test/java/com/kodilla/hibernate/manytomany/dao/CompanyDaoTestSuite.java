package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarkson = new Employee("Stephanie", "Clarkson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMasters = new Company("Data Masters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMasters.getEmployees().add(stephanieClarkson);
        dataMasters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarkson.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMasters);
        int dataMastersId = dataMasters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMastersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMastersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testRetrieveEmployeesWithLastname() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        employeeDao.save(johnSmith);
        int id1 = johnSmith.getId();
        Employee stephanieClarkson = new Employee("Stephanie", "Clarkson");
        employeeDao.save(stephanieClarkson);
        int id2 = stephanieClarkson.getId();
        Employee amandaSmith = new Employee("Amanda", "Smith");
        employeeDao.save(amandaSmith);
        int id3 = amandaSmith.getId();

        //When
        List<Employee> employeesWithLastName = employeeDao.retrieveEmployeesWithLastname("Smith");

        //Then
        assertEquals(2, employeesWithLastName.size());

        //CleanUp
        try {
            employeeDao.deleteById(id1);
            employeeDao.deleteById(id2);
            employeeDao.deleteById(id3);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testRetrieveCompaniesWithFirst3Letters() {
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
        List<Company> companiesWithFirst3Letters = companyDao.retrieveCompaniesWithFirst3Letters("Dat");

        //Then
        try {
            assertEquals(2, companiesWithFirst3Letters.size());
        } finally {
            //CleanUp
            companyDao.deleteById(id1);
            companyDao.deleteById(id2);
            companyDao.deleteById(id3);
        }
    }
}