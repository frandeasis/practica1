package com.curso.hellohibernate;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.hellohibernate.model.Department;
import com.curso.hellohibernate.model.Employee;
import com.curso.hellohibernate.service.EmployeeService;

public class AppHibernate 
{
           public static void main(String[] args) {
        	           ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        	           Employee em = new Employee();
//        	           em.setId("123");
        	           em.setName("John");
        	           em.setAge(35);
        	           EmployeeService emService = (EmployeeService) context.getBean("employeeService");
        	           emService.persistEmployee(em);
        	           System.out.println("Updated age :" + emService.findEmployeeById(1L).getAge());       
        	           em.setAge(32);
        	           
        	           
        	           Department dep = new Department();
        	           em.setDepartment(dep);
        	           emService.persistDepartment(dep);
        	           emService.updateEmployee(em);
        	           System.out.println("Updated age :" + emService.findEmployeeById(1L).getAge());
        	           //emService.deleteEmployee(em);
        	           context.close();
           }
}