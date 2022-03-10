package com.curso.hellohibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.hellohibernate.dao.EmployeeDao;
import com.curso.hellohibernate.model.Department;
import com.curso.hellohibernate.model.Employee;
import com.curso.hellohibernate.service.EmployeeService;
 
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
 
    @Autowired
    EmployeeDao employeeDAO;
    
    @Transactional()
    public void persistEmployee(Employee employee) {
        employeeDAO.persistEmployee(employee);
         
    }
 
    @Transactional()
    public void persistDepartment(Department department) {
        employeeDAO.persistDepartment(department);
         
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
