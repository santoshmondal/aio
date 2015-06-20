package com.rediff.shibernate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Basicorm {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean-orm.xml");

		EmployeeDaoSessionFactoryTxn dao = (EmployeeDaoSessionFactoryTxn) context.getBean("daoref");

		Employee e = new Employee();
		e.setName("varun1");
		e.setSalary(50000);

		// dao.saveEmployee(e);
		List<Employee> listAll = dao.listAll();
		System.out.println(listAll);
	}
}
