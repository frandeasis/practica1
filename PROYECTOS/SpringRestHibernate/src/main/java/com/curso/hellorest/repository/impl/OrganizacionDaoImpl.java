package com.curso.hellorest.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.curso.hellorest.component.Organizacion;
import com.curso.hellorest.repository.OrganizacionDao;

@Repository("organizacionDao")
public class OrganizacionDaoImpl implements OrganizacionDao {

    @Autowired
    private SessionFactory sessionFactory;
	
	public void persistOrganizacion(Organizacion organizacion) {
		sessionFactory.getCurrentSession().persist(organizacion);
	}

	public void updateOrganizacion(Organizacion organizacion) {
		sessionFactory.getCurrentSession().update(organizacion);;
	}

	public Organizacion findOrganizacionById(Long id) {
		return (Organizacion) sessionFactory.getCurrentSession().get(Organizacion.class, id);
	}

	public void deleteOrganizacion(Organizacion organizacion) {
		sessionFactory.getCurrentSession().delete(organizacion);
	}

}
