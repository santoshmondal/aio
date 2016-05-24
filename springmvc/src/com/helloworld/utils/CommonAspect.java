package com.helloworld.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class CommonAspect {
	public void logRequestAdvice() {
		System.out.println("LOG REQUEST!!");
	}
	
	public void logRequestAdvice1(String param1) {
		System.out.println("LOG REQUEST1!! :: " + param1);
	}
	
	public void logRequestAdviceAround(ProceedingJoinPoint joinpoint,  String param1) {
		System.out.println("Around Before  :: " + param1);
		
		try{
			
			joinpoint.proceed();
			
		} catch(Throwable e){
			e.printStackTrace();
		}
		
		System.out.println("Around After :: " + param1);
	}
	
	public void afterMethodAdvice() {
		System.out.println("AFTER METHOD ADVICE!!");
	}
}
