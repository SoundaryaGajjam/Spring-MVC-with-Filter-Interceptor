package com.scp.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Scoopen")
public class MyException extends RuntimeException {

	public MyException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	
}
