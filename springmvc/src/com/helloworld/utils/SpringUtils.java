package com.helloworld.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {
	
	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	
	public static ApplicationContext getApplicationContext() {
		return context;
	}
}
