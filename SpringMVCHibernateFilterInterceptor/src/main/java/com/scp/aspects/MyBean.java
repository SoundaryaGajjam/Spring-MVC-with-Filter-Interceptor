package com.scp.aspects;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.journaldev.spring.model.Person;

@Configuration
public class MyBean {
	@Bean
	public Person m1(){
		return new Person();
	}
}
