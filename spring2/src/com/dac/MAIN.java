package com.dac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MAIN {
	public static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	public static void main(String[] args) {
		Sample obj1 = (Sample)context.getBean("bean1");
		System.out.println(obj1.getName() + " :: " + obj1.getId() + " :: " + obj1.getNo());
		
		Sample obj2 = (Sample)context.getBean("bean2");
		System.out.println(obj2.getName() + " :: " + obj2.getNo());
		
		
		Sample obj3 = (Sample)context.getBean("bean3");
		System.out.println(obj3.getName() + " :: " + obj3.getLo());
		
		
		Sample obj4 = (Sample)context.getBean("sample1");
		System.out.println(obj4.getTest().getId());
		
		
		Sample obj5 = (Sample)context.getBean("sample2");
		System.out.println(obj5);
		
		
		Test1 test1 = (Test1)context.getBean("demo1");
		System.out.println(test1);
		
		Sample obj6 = (Sample)context.getBean("sample3");
		System.out.println(obj6);
		
	}
}
