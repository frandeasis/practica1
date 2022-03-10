package com.curso.hellorest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curso.hellorest.component.Country;
import com.curso.hellorest.component.Employee;
import com.curso.hellorest.service.CountryServ;
import com.curso.hellorest.service.DepartmentService;
import com.curso.hellorest.service.EmployeeService;
import com.curso.hellorest.service.OrganizacionService;

@RestController
public class CountryCtrl {

	@Autowired
	private CountryServ cservice;
	
	@Autowired
	private DepartmentService dserv;
	
	@Autowired
	private EmployeeService eserv;
	
	@Autowired
	private OrganizacionService oserv;

	@RequestMapping(value="/getEmployee/{em}", method=RequestMethod.POST, headers="Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById(@PathVariable(name="em") Long id) {
		return eserv.findEmployeeById(id);
	}
	
	// Get all countries
	@RequestMapping(value="/getCountries", method=RequestMethod.GET, headers="Accept=application/json")
	public List<Country> getCountries() {
		List<Country> list = cservice.getAllCountries();		
		return list;
	}

	// Get a country by id
	@RequestMapping(value="/getCountry/{id}", method=RequestMethod.GET, headers="Accept=application/json")
	public Country getCountryById(@PathVariable(name="id") int id) {
		return cservice.getCountry(id);
	}	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, headers="Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Country>> save(@RequestBody CountryWrapper wrapper) {

		//countries.stream().forEach(c -> c.setCpopulation(c.getCpopulation() + 100));
		
		List<Country> saved = cservice.saveCountries(wrapper.getCountries());
	    // TODO: call persistence layer to update
	    return new ResponseEntity<List<Country>>(saved, HttpStatus.OK);
	}	
}