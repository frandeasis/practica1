package com.curso.hellohibernate.service;

import com.curso.hellohibernate.model.Department;

public interface DepartmentService {
	void persistDepartment(Department department);
	
	void updateDepartment(Department department);
	
	Department findDepartmentById(Long id);
    void deleteDepartment(Department department);
}
