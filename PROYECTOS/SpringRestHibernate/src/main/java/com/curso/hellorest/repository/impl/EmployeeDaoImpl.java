package com.curso.hellorest.repository.impl;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.curso.hellorest.component.Country;
import com.curso.hellorest.component.Employee;
import com.curso.hellorest.repository.EmployeeDao;
 
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
 
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
    	Session session;
		try {
		    session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			//Session closed
		    session = sessionFactory.openSession();
		}
		return session;

    }    
    
    public void persistEmployee(Employee employee) {
        sessionFactory.getCurrentSession().persist(employee);
    }
 
    public Employee findEmployeeById(Long id) {
//    	Query query = sessionFactory.getCurrentSession().getNamedQuery("EmpleadosDepartamento");
//    	query.setParameter("idDepartmento", 1L);
//        List<Employee> empleados = query.getResultList();
//        System.out.println(empleados);
    	
    	return (Employee) getSession().get(Employee.class, id);
    }
 
    public void updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
 
    }
    public void deleteEmployee(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
 
    }
 
}