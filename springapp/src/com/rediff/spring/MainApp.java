package com.rediff.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Student student = (Student) context.getBean("student");

		student.getName();
		student.getAge();
		student.setName("rajaa");
		student.setSomething(student.getName(), student.getAge());

		student.setAge(student.getAge());

		// student.printThrowException();
	}
}
