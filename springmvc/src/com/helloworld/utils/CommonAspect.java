package com.helloworld.utils;

public class CommonAspect {
	public void logRequestAdvice() {
		System.out.println("LOG REQUEST!!");
	}
	
	public void afterMethodAdvice() {
		System.out.println("AFTER METHOD ADVICE!!");
	}
}
