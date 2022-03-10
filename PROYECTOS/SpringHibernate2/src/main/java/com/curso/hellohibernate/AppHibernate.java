package com.curso.hellohibernate;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.hellohibernate.model.Department;
import com.curso.hellohibernate.model.Employee;
import com.curso.hellohibernate.model.Organizacion;
import com.curso.hellohibernate.service.DepartmentService;
import com.curso.hellohibernate.service.EmployeeService;
import com.curso.hellohibernate.service.OrganizacionService;

public class AppHibernate 
{
           public static void main(String[] args) {
        	           ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        	           EmployeeService emService = (EmployeeService) context.getBean("employeeService");
        	           OrganizacionService orgService = (OrganizacionService) context.getBean("organizacionService");
        	           DepartmentService depService	 = (DepartmentService) context.getBean("departmentService");

        	           Organizacion org = new Organizacion();
        	           org.setDireccion("Calle Anabel Segura, 7");
        	           org.setName("Indra company");
        	           org.setNif("123456789Z");
        	           orgService.persistOrganizacion(org);
        	           
        	           Department dep1 = new Department();
        	           dep1.setName("Sistemas");
        	           Department dep2 = new Department();
        	           dep2.setName("Presentaciones técnicas de éxito");
        	           
        	           depService.persistDepartment(dep1);
        	           depService.persistDepartment(dep2);
        	           
        	           
        	           Employee em1 = new Employee();
        	           em1.setName("Bob");
        	           em1.setAge(35);
        	           
        	           Employee em2 = new Employee();
        	           em2.setName("Alice");
        	           em2.setAge(35);
        	           
        	           emService.persistEmployee(em1);
        	           emService.persistEmployee(em2);

        	           dep1.setOrganizacion(org);
        	           dep2.setOrganizacion(org);
        	           depService.updateDepartment(dep1);
        	           depService.updateDepartment(dep2);
        	           
        	           em1.setDepartment(dep1);
        	           em2.setDepartment(dep2);
        	           
        	           emService.updateEmployee(em1);
        	           emService.updateEmployee(em2);
//        	           emService.updateOrganizacion(org);      	         

//        	           em.setId("123");
//        	           em.setName("John");
//        	           em.setAge(35);
//        	           emService.persistEmployee(em);
//        	           System.out.println("Updated age :" + emService.findEmployeeById(1L).getAge());       
//        	           em.setAge(32);
//        	           
//        	           Department dep = new Department();
//        	           dep.setName("Sistemas");
//        	           emService.persistDepartment(dep);
//        	           em.setDepartment(dep);
//        	           emService.updateEmployee(em);
//        	           System.out.println("Updated age :" + emService.findEmployeeById(1L).getAge());
//        	           emService.deleteEmployee(em);
        	           context.close();
           }
}