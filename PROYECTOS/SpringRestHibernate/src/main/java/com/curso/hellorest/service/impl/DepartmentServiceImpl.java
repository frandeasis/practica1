package com.curso.hellorest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.hellorest.component.Department;
import com.curso.hellorest.repository.DepartmentDao;
import com.curso.hellorest.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDao departmentDAO;
	
	@Transactional
	public void persistDepartment(Department department) {
		departmentDAO.persistDepartment(department);
	}

	@Transactional
	public void updateDepartment(Department department) {
		departmentDAO.updateDepartment(department);
	}

	@Transactional
	public Department findDepartmentById(Long id) {
		return departmentDAO.findDepartmentById(id);
	}

	@Transactional
	public void deleteDepartment(Department department) {
		departmentDAO.deleteDepartment(department);
	}

}
