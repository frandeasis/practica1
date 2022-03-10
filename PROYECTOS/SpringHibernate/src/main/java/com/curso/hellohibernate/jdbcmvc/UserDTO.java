package com.curso.hellohibernate.jdbcmvc;

import java.util.Date;
import java.io.Serializable;

public class UserDTO {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String surname;
	private String title;
	private Date created;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
}
