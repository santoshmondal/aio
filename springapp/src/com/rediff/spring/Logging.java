package com.rediff.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Logging {
	/**
	 * This is the method which I would like to execute before a selected method
	 * execution.
	 */
	public void beforeAdvice(JoinPoint jp, String name) {
		Object[] args = jp.getArgs();
		if (args != null) {
			for (Object obj : args) {
				System.out.println("BEFORE the help of JoinPoint :: " + obj);
			}
		}
		System.out.println("BEFORE String requset..." + name);
	}

	/**
	 * This is the method which I would like to execute after a selected method
	 * execution.
	 */
	public void afterAdvice(JoinPoint jp, String name) {
		Object[] args = jp.getArgs();
		if (args != null) {
			for (Object obj : args) {
				System.out.println("AFTER the help of JoinPoint :: " + obj);
			}
		}
		System.out.println("After String requset..." + name);
	}

	public void aroundAdvice(ProceedingJoinPoint jp, String name, Integer id) {
		try {

			Object[] args = jp.getArgs();
			if (args != null) {
				for (Object obj : args) {
					System.out.println("Arround the help of JoinPoint :: " + obj);
				}
			}
			jp.proceed();

			System.out.println("Around String requset..." + name + " ::  " + id);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * This is the method which I would like to execute when any method returns.
	 */
	public void afterReturningAdvice(JoinPoint joinPoint, Object retValue) {

		System.out.println("Returning:" + retValue);
	}

	/**
	 * /** This is the method which I would like to execute if there is an
	 * exception raised.
	 */
	public void afterThrowingAdvice(JoinPoint jp, Throwable error) {
		System.out.println("There has been an exception: " + error.toString());
	}
}
