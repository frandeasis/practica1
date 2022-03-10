package com.curso.hellohibernate.service;

import com.curso.hellohibernate.model.Employee;

public interface EmployeeService {
	
//	void persistOrganizacion(Organizacion organizacion);
	void persistEmployee(Employee employee);
//	void persistDepartment(Department department);
	
	void updateEmployee(Employee employee);
//	void updateDepartment(Department department);
//	void updateOrganizacion(Organizacion organizacion);
	
    Employee findEmployeeById(Long id);
    void deleteEmployee(Employee employee);
}
