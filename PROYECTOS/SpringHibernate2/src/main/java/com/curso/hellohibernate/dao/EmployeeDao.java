package com.curso.hellohibernate.dao;

import org.springframework.stereotype.Repository;

import com.curso.hellohibernate.model.Department;
import com.curso.hellohibernate.model.Employee;
import com.curso.hellohibernate.model.Organizacion;

@Repository
public interface EmployeeDao {
    
    void persistEmployee(Employee employee);
     
    Employee findEmployeeById(Long id);
     
    void updateEmployee(Employee employee);
     
    void deleteEmployee(Employee employee);
}