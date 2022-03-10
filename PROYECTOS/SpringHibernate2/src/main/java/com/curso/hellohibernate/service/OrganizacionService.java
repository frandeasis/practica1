package com.curso.hellohibernate.service;

import com.curso.hellohibernate.model.Organizacion;

public interface OrganizacionService {
	void persistOrganizacion(Organizacion organizacion);
	
	void updateOrganizacion(Organizacion organizacion);
	
	Organizacion findDOrganizacionById(Long id);

    void deleteOrganizacion(Organizacion organizacion);
}
