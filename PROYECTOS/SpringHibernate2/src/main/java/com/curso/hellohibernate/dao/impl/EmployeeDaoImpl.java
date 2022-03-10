package com.curso.hellohibernate.dao.impl;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.curso.hellohibernate.dao.EmployeeDao;
import com.curso.hellohibernate.model.Employee;
 
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public void persistEmployee(Employee employee) {
        sessionFactory.getCurrentSession().persist(employee);
    }
 
    public Employee findEmployeeById(Long id) {
//    	Query query = sessionFactory.getCurrentSession().getNamedQuery("EmpleadosDepartamento");
//    	query.setParameter("idDepartmento", 1L);
//        List<Employee> empleados = query.getResultList();
//        System.out.println(empleados);
        
    	return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
    }
 
    public void updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
 
    }
    public void deleteEmployee(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
 
    }
 
}