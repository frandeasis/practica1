package com.curso.hellorest.service;

import com.curso.hellorest.component.Organizacion;

public interface OrganizacionService {
	void persistOrganizacion(Organizacion organizacion);
	
	void updateOrganizacion(Organizacion organizacion);
	
	Organizacion findDOrganizacionById(Long id);

    void deleteOrganizacion(Organizacion organizacion);
}
