package net.javaguides.springannotations.repository;

import org.springframework.stereotype.Repository;

//Annotation below is derived from the @Component annotation
//i.e. it's a specialization of @Component
//We keep all database related logic in this class
@Repository
public class MyRepository {
	
	public String hello() {
		return "Hello Repository";
	}

}
