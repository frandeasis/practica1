package com.curso.hellohibernate.dao;

import org.springframework.stereotype.Repository;

import com.curso.hellohibernate.model.Department;

@Repository
public interface DepartmentDao{
	void persistDepartment(Department department);
	
	void updateDepartment(Department department);
	
	Department findDepartmentById(Long id);
    void deleteDepartment(Department department);
}
