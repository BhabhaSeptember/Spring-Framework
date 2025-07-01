package net.javaguides.springannotations.controller;

import org.springframework.stereotype.Controller;

//Annotation below is derived from the @Component annotation
//i.e. it's a specialization of @Component
//We can write logic that handles HTTP requests in this class
@Controller
public class MyController {
	
	public String hello() {
		return "Hello Controller";
	}
	
}
