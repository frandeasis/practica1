package com.curso.hellorest.service;

import com.curso.hellorest.component.Employee;

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
