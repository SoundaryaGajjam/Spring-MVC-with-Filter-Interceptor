package com.journaldev.spring;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages ={ "com.journaldev.spring.PersonController"})
public class MyAdviceException {//extends RuntimeException{
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Global Exception Scoopen")
	@ExceptionHandler(IOException.class)
	public void myExceptionMethod(){
		System.out.println("GlobAL Exception");
	}
}
