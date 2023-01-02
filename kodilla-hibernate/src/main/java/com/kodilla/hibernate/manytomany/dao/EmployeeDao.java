package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    List<Employee> retrieveEmployeesWithLastname(@Param("LASTNAME") String lastname);

    @Query(nativeQuery = true)
    List<Employee> retrieveEmployeesWithFirstnamesContaining(@Param("ARG") String arg);

    @Query(nativeQuery = true)
    List<Employee> retrieveEmployeesWithLastnamesContaining(@Param("ARG") String arg);
}
