package com.curso.hellohibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
 

/**
 * 
 * */
@Entity
@Table(name = "Empleado")
@NamedQueries({ @NamedQuery(name = "EmpleadosDepartamento", 
				query = "SELECT e from Employee e WHERE e.department.id=:idDepartmento") })
public class Employee {
 
    @Id
    @Column(name = "ID", nullable = false, length = 30)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
 
    @Column(name = "NAME", nullable = false, length = 50)
    private String name;
 
    @Column(name = "AGE", nullable = false,  length = 50)
    private long age;
    
    @ManyToOne(targetEntity = Department.class)
    private Department department;
     
    public Employee() {
    }
 
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
 
    public long getAge() {
        return age;
    }
 
    public void setAge(long age) {
        this.age = age;
    }

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
 
}