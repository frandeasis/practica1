package com.curso.hellohibernate;

import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.curso.hellohibernate.config.HibernateConfigBean;
import com.curso.hellohibernate.jdbcmvc.JdbcService;
import com.curso.hellohibernate.jdbcmvc.UserDTO;

public class AppJdbTemplate 
{
	private static JdbcTemplate template;
	private static NamedParameterJdbcTemplate namedTemplate;
    private static final String deleteSql = "DELETE FROM employee WHERE id = ?";
	
	private static final String insertSql =
    		  "INSERT INTO employee (" +
    		  " name, " +
    		  " surname, " +
    		  " title, " +
    		  " created) " +
    		  "VALUES (?, ?, ?, ?)";
	//private static final String selectSql = "SELECT * FROM employee;";
	
	/**
	 * 
 CREATE TABLE employee (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  surname VARCHAR(45) NOT NULL,
  title VARCHAR(45) NOT NULL,
  created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);
	 * */
    public static void main( String[] args ) {
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(HibernateConfigBean.class);
//    	template = ctx.getBean(JdbcTemplate.class);
//    	namedTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
//    	
//		AppJdbTemplate.save("Juan", "Perez", "Mr", new Date());
//		AppJdbTemplate.query();
//		//AppJdbTemplate.delete(1);
    	
    	UserDTO dto = new UserDTO();
    	dto.setId(null);
    	dto.setName("Daniel");
    	dto.setSurname("XXXXX");
    	dto.setTitle("YYYYY");
    	dto.setCreated(new Date());
    	JdbcService service = ctx.getBean(JdbcService.class);
    	try {
			service.guardarUsuario(dto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	
    }
    
    public static void save(String name, String surname, String title, Date created) {
        // definir argumentos de la query
        Object[] params = new Object[] { name, surname, title, new Date() };
         
        // definir los tipos de datos SQL para cada columna
        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP };
 
        // ejecutar la consulta. Devuelve el número de registros insertados.
        int row = template.update(insertSql, params, types);
        System.out.println("Registros insertados: "+row);         
    }
    
    
    public static void delete(Integer id) {
    	Object[] params = { id };
        int[] types = {Types.BIGINT};
        int rows = template.update(deleteSql, params, types);
        System.out.println("Se han eliminado: "+rows+"");
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void query() {
    	String sql = "select * from employee where surname = :surname";
		Map parameters = new HashMap();
        parameters.put("surname", "Perez");
        
        SqlRowSet rowSet = namedTemplate.queryForRowSet(sql, parameters);
        while (rowSet.next()) {
            System.out.println("RowNumber: " + rowSet.getRow());
            for (int i = 1; i < rowSet.getMetaData().getColumnCount(); i++) {
                System.out.println("ColumName: " + rowSet.getMetaData().getColumnName(i) + ", value: " + rowSet.getObject(i));
            }
             
        }
        

        
    	/*
        List<Map<String, Object>> employees = template.queryForList(selectSql);
        if (employees!=null && !employees.isEmpty()) {
            for (Map<String, Object> employee : employees) {
                for (Iterator<Map.Entry<String, Object>> it = employee.entrySet().iterator(); it.hasNext();) {
                    Map.Entry<String, Object> entry = it.next();
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    System.out.println(key + " = " + value);
                }
                System.out.println();
            }
        } */   	

    }
}
