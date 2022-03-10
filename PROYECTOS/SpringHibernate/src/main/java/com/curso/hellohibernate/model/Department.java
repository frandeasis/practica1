package com.curso.hellohibernate.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Departamento")
public class Department {
	   @Id 
	   @GeneratedValue( strategy=GenerationType.AUTO )
	   private Long id;
	   
	   @Column(name="NAME")
	   private String name;

	   @OneToMany(targetEntity = Employee.class)
	   private List<Employee> employees;
	   
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

}
