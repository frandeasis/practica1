package com.curso.hellohibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.hellohibernate.dao.OrganizacionDao;
import com.curso.hellohibernate.model.Employee;
import com.curso.hellohibernate.model.Organizacion;
import com.curso.hellohibernate.service.OrganizacionService;

@Service("organizacionService")
public class OrganizacionServiceImpl implements OrganizacionService {

    @Autowired
    OrganizacionDao organizacionDAO;
	
    @Transactional
	public void persistOrganizacion(Organizacion organizacion) {
		organizacionDAO.persistOrganizacion(organizacion);
	}


    @Transactional
	public void updateOrganizacion(Organizacion organizacion) {
    	organizacionDAO.updateOrganizacion(organizacion); 
	}


    @Transactional
    public void deleteOrganizacion(Organizacion organizacion) {
    	organizacionDAO.deleteOrganizacion(organizacion);
         
    }


    @Transactional
	public Organizacion findDOrganizacionById(Long id) {
    	return organizacionDAO.findOrganizacionById(id);
	}

}
