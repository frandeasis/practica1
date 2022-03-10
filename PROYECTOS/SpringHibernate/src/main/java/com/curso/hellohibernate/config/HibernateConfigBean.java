package com.curso.hellohibernate.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration()
@ComponentScan(basePackages = "com.curso.hellohibernate.jdbcmvc")
@PropertySource("classpath:db.properties")
public class HibernateConfigBean  {
	
    @Bean
    DataSource dataSource(Environment env) {
    	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	  dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
    	  dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
    	  dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
    	  dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
    	  return dataSource;
    }
     
    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);        
    }
     
    @Bean
    DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    } 
    
    @Bean
    NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);        
    }
    
}
