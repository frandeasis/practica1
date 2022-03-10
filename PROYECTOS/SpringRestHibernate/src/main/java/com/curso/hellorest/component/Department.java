package com.curso.hellorest.component;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Departamento")
public class Department {
	   @Id 
	   @GeneratedValue(strategy = GenerationType.SEQUENCE)
	   private Long id;
	   
	   @Column( name="nombreDepartamento" , nullable = false, length = 60)
	   private String name;

	   @ManyToOne
	   private Organizacion organizacion;
	   
	   @OneToMany(cascade = CascadeType.ALL)
	   private List<Employee> empleados;
	   
	   
	   public Long getId() 
	   {
	      return id;
	   }
	    
	   public void setId(Long id) 
	   {
	      this.id = id;
	   }
	    
	   public String getName( )
	   {
	      return name;
	   }
	    
	   public void setName( String deptName )
	   {
	      this.name = deptName;
	   }

	public Organizacion getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}

	public List<Employee> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Employee> empleados) {
		this.empleados = empleados;
	}

}
