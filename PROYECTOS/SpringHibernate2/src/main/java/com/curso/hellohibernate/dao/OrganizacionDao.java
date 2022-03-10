package com.curso.hellohibernate.dao;

import org.springframework.stereotype.Repository;

import com.curso.hellohibernate.model.Organizacion;

@Repository
public interface OrganizacionDao {
	void persistOrganizacion(Organizacion organizacion);

	void updateOrganizacion(Organizacion organizacion);

    Organizacion findOrganizacionById(Long id);
    
    void deleteOrganizacion(Organizacion employee);
}
