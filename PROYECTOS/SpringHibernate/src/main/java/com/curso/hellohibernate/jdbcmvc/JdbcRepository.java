package com.curso.hellohibernate.jdbcmvc;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepository {
	@Autowired
	private JdbcTemplate template;
	
	@Autowired
	private NamedParameterJdbcTemplate namedTemplate;
	
	private static final String deleteSql = "DELETE FROM employee WHERE id = ?";
	
	private static final String insertSql = 
			"INSERT INTO employee (" +
					" name, " +
					" surname, " +
					" title, " +
					" created) " +
					"VALUES (?, ?, ?, ?)";
	
	public int save(UserDTO user) {
        // definir argumentos de la query
        Object[] params = new Object[] { user.getName(), user.getSurname(), user.getTitle(), user.getCreated() };
         
        // definir los tipos de datos SQL para cada columna
        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP };
 
        // ejecutar la consulta. Devuelve el número de registros insertados.
        int row = template.update(insertSql, params, types);
        System.out.println("Registros insertados: "+row);         
        return row;
	}
	
    public int delete(UserDTO user) {
    	Object[] params = { user.getId()};
        int[] types = {Types.BIGINT};
        int rows = template.update(deleteSql, params, types);
        System.out.println("Se han eliminado: "+rows+"");
        return rows;
    }
}
