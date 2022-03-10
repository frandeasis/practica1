package com.curso.hellorest.repository;

import org.springframework.stereotype.Repository;

import com.curso.hellorest.component.Employee;

@Repository
public interface EmployeeDao {
    
    void persistEmployee(Employee employee);
     
    Employee findEmployeeById(Long id);
     
    void updateEmployee(Employee employee);
     
    void deleteEmployee(Employee employee);
}