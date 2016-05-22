package com.dac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * concept of differnt type of java classes
 * 
 * usage of spring,
 * 
 * singleton/reflection
 * aop
 * web mvc
 * jdbc
 * 
 * 
 * concept of bean
 * 
 * Maven Concept, pom.xml
 * beans.xml
 */
public class HelloSpring {
	public static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("beans.xml");

		Student student = (Student) context.getBean("student");
		System.out.println(student);

	}
}
