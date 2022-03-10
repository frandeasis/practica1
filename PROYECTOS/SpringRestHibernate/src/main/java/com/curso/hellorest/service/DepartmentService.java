package com.curso.hellorest.service;

import com.curso.hellorest.component.Department;

public interface DepartmentService {
	void persistDepartment(Department department);
	
	void updateDepartment(Department department);
	
	Department findDepartmentById(Long id);
    void deleteDepartment(Department department);
}
