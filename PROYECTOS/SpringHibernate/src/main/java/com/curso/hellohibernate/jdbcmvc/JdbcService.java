package com.curso.hellohibernate.jdbcmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JdbcService {

	@Autowired
	private JdbcRepository repository;
	
	public int guardarUsuario(UserDTO userDTO) throws Exception {
		if (userDTO == null || userDTO.getName().equals("")) {
			throw new Exception("DTO [nombre] Invalido");
		}
		return repository.save(userDTO);
	}
	
	public int eliminarUsuario(UserDTO userDTO) throws Exception {
		if(userDTO == null || userDTO.getId() == 0) {
			throw new Exception("DTO [id] Invalido");
		}
		return repository.delete(userDTO);
		
	}
}
