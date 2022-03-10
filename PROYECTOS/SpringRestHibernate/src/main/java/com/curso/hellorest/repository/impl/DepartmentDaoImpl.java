package com.curso.hellorest.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.curso.hellorest.component.Department;
import com.curso.hellorest.repository.DepartmentDao;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    @Autowired
    private SessionFactory sessionFactory;
	
	public void persistDepartment(Department department) {
        sessionFactory.getCurrentSession().persist(department);
	}

	public void updateDepartment(Department department) {
        sessionFactory.getCurrentSession().update(department);
	}

	public Department findDepartmentById(Long id) {
		return (Department) sessionFactory.getCurrentSession().get(Department.class, id);
	}

	public void deleteDepartment(Department department) {
		sessionFactory.getCurrentSession().delete(department);
		
	}

}
