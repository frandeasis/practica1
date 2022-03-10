package com.curso.hellorest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.hellorest.component.Employee;
import com.curso.hellorest.repository.EmployeeDao;
import com.curso.hellorest.service.EmployeeService;
 
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
 
    @Autowired
    EmployeeDao employeeDAO;
     
    @Transactional()
    public void persistEmployee(Employee employee) {
        employeeDAO.persistEmployee(employee);
         
    }
 
    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
         
    }
    
    @Transactional
    public Employee findEmployeeById(Long id) {
        return employeeDAO.findEmployeeById(id);
    }
 
    @Transactional
    public void deleteEmployee(Employee employee) {
        employeeDAO.deleteEmployee(employee);
         
    }
}
