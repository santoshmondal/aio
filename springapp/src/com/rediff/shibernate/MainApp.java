package com.rediff.shibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		EmployeeDao dao = (EmployeeDao) context.getBean("d");

		Employee e = new Employee();
		e.setId(124);
		e.setName("varun");
		e.setSalary(50000);

		dao.saveEmployee(e);

		/*EmployeeDaoSessionFactory dao = (EmployeeDaoSessionFactory) context.getBean("d1");

		Employee e = new Employee();
		e.setId(121);
		e.setName("varun2");
		e.setSalary(50000);

		dao.saveEmployee(e);*/

		/*EmployeeDaoSessionFactoryTxn dao = (EmployeeDaoSessionFactoryTxn) context.getBean("d2");

		Employee e = new Employee();
		e.setId(120);
		e.setName("varun1");
		e.setSalary(50000);

		dao.saveEmployee(e);*/
	}
}
