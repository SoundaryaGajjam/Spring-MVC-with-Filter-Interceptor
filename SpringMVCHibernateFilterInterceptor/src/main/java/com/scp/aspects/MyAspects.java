package com.scp.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspects {
	
	@Before("execution(* com.journaldev.spring.model.Person.myMethod(..))")
	public void AdviceOnlistPersons(){
		System.out.println("Before --> My advice is executed ");
	}
}
