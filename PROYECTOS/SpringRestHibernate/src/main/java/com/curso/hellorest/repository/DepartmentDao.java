package com.curso.hellorest.repository;

import org.springframework.stereotype.Repository;

import com.curso.hellorest.component.Department;

@Repository
public interface DepartmentDao{
	void persistDepartment(Department department);
	
	void updateDepartment(Department department);
	
	Department findDepartmentById(Long id);
    void deleteDepartment(Department department);
}
