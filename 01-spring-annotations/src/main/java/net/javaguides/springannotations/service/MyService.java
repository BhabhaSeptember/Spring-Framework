package net.javaguides.springannotations.service;

import org.springframework.stereotype.Service;

//Annotation below is derived from the @Component annotation
//i.e. it's a specialization of @Component
//We keep business logic in a service class
@Service
public class MyService {
	
	public String hello() {
		return "Hello Service";
	}

}
