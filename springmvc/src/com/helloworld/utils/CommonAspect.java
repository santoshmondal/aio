package com.helloworld.utils;

public class CommonAspect {
	public void logRequestAdvice() {
		System.out.println("LOG REQUEST!!");
	}
	
	public void logRequestAdvice1(String param1) {
		System.out.println("LOG REQUEST1!! :: " + param1);
	}
	
	public void afterMethodAdvice() {
		System.out.println("AFTER METHOD ADVICE!!");
	}
}
