package com.journaldev.spring;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.service.PersonService;

@Controller
public class PersonController {
	
	//@Autowired(required=true)
	private PersonService personService;
	
	/*@Autowired
	MyBean b;*/
	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}
	
	/* 2nd way
	 * @ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="Pune")
	@ExceptionHandler(IOException.class)
	public void myExceptionMethod(){
		System.out.println("handling");
	}*/
	
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		
		/*if(true)
			throw new IOException("Hii");*/
			//throw new IOException("User defined exception"); //2nd way
			//throw new MyException("User defined exception");// 1st way
		
		
		/*if(10/0==0){
			throw new RuntimeException("Hii");
			*/
		
		
		
		/*Person p=b.m1();
		p.myMethod();*/
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		
		if(p.getId() == 0){
			//new person, add it
			this.personService.addPerson(p);
		}else{
			//existing person, call update
			this.personService.updatePerson(p);
		}
		
		return "redirect:/persons";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.removePerson(id);
        return "redirect:/persons";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }
	
}
