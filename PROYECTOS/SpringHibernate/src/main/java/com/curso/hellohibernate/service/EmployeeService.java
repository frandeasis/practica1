package com.curso.hellohibernate.service;

import com.curso.hellohibernate.model.Department;
import com.curso.hellohibernate.model.Employee;

public interface EmployeeService {
	void persistEmployee(Employee employee);
	void persistDepartment(Department department);
    Employee findEmployeeById(Long id);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
