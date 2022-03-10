package com.curso.hellorest.repository;

import org.springframework.stereotype.Repository;

import com.curso.hellorest.component.Organizacion;

@Repository
public interface OrganizacionDao {
	void persistOrganizacion(Organizacion organizacion);

	void updateOrganizacion(Organizacion organizacion);

    Organizacion findOrganizacionById(Long id);
    
    void deleteOrganizacion(Organizacion employee);
}
