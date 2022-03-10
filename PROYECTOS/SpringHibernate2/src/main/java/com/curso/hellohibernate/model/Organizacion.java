package com.curso.hellohibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Organizacion")
public class Organizacion {
	
	   @Id 
	   @GeneratedValue( strategy=GenerationType.AUTO )
	   private Long id;
	   
	   @Column(name="ORG_NAME", nullable = false, length = 30)
	   private String name;
	   
	   @Column(name="ORG_DIRECCION", nullable = false, length = 60)
	   private String direccion;
	   
	   @Column(name="NIF",  nullable = false, length = 10)
	   private String nif;
	   
	   @OneToMany(cascade = CascadeType.ALL)
	   private List<Department> departamentos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Department> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Department> departamentos) {
		this.departamentos = departamentos;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}
	   
	   
}
