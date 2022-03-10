package com.curso.hellorest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.hellorest.component.Organizacion;
import com.curso.hellorest.repository.OrganizacionDao;
import com.curso.hellorest.service.OrganizacionService;

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
