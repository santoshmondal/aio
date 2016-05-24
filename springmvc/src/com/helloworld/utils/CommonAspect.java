package com.helloworld.utils;

public class CommonAspect {
	public void logRequestAdvice() {
		System.out.println("LOG REQUEST!!");
	}
	
	public void logRequestAdvice1(String sname) {
		System.out.println("LOG REQUEST1!! :: " + sname);
	}
	
	public void afterMethodAdvice() {
		System.out.println("AFTER METHOD ADVICE!!");
	}
}
