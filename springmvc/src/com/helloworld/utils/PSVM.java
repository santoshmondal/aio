package com.helloworld.utils;

import org.springframework.context.ApplicationContext;

public class PSVM {
	public static void main(String[] args) {
		ApplicationContext context = SpringUtils.getApplicationContext();
		HelloSpring bean = (HelloSpring)context.getBean("bean1");
		
		//System.out.println(bean.getSname());
		//System.out.println(bean.getSid());
		
		bean.setSname("testafdfa");
	}
}
