package net.javaguides.springannotations.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springannotations.beans.Book;

//NOTES: 
//Spring provides @Controller annotation to make a Java class as a Spring
//MVC controller. It indicates that this class serves the role of 
//controller
//Controllers in Spring MVC web application is a component that handles
//incoming HTTP requests
//It is a specialization of @Component class which allows for auto-
//detection of implementation classes through classpath scanning
//We use @Controller in combination with @RequestMapping for request
//handling methods
//@ResponseBody annotation is also used to bind the return value of a 
//method directly to the HTTP JSON response body instead of rendering a 
//view e.g. Thymeleaf 
//i.e. convert Java object to JSON body and return that to client

//MUST USE below annotation when developing Spring MVC web application that
//returns a view
//@Controller
//
//We can use the below annotation at class level instead of for each method
//@ResponseBody 
//
//When developing RESTful web services using Spring MVC we can use below
//annotation which is a combination of @Controller and @RequestBody
@RestController
//
@RequestMapping("/api") // base url for all controller class REST api's
public class BookController {

	@RequestMapping("/hello-world")
//	@ResponseBody
	public String helloWorld() {
		return "Hello Book Controller";
	}

//MULTIPLE URL's	
//	@RequestMapping(value = { "/book", "/core-java", "/java" },
//			
//			method = RequestMethod.GET, // default HTTP method for
//																							// @RequestMapping
//			produces = { MediaType.APPLICATION_JSON_VALUE, // api produces result in JSON format
//					MediaType.APPLICATION_XML_VALUE }, // api produces result in XML format
//			
//			consumes = { MediaType.APPLICATION_JSON_VALUE, // api consumes result from client in JSON format
//					MediaType.APPLICATION_XML_VALUE } // api consumes result from client in XML format
//	) 
////	@ResponseBody
//	public Book getBook() {
//		Book book = new Book(1, "Core Java", "Learn Core Java & Latest Features");
//		return book;
//	}
	
//====================================================================================
	
//Below is combination of @RequestMapping  it's HTTP (method = RequestMethod.GET)	
	@GetMapping(value = { "/book", "/core-java", "/java" }) 
	public Book getBook() {
		Book book = new Book(1, "Core Java", "Learn Core Java & Latest Features");
		return book;
	}
	

//====================================================================================

//This REST API consumes data that is in JSON format from the request
	
//The @RequestBody annotation is responsible for retrieving the JSON data from the
//request body and converting it to a book Java object
//	@RequestMapping(value = "/books/create", method = RequestMethod.POST)
	@PostMapping(value = "/books/create",
			consumes = MediaType.APPLICATION_JSON_VALUE) //shortcut for above

//Annotation below specifies Http Status 201 for the REST API	
//	@ResponseStatus(value = HttpStatus.CREATED)
//	public Book createBook(@RequestBody Book book) {
//		System.out.println(book.getId());
//		System.out.println(book.getTitle());
//		System.out.println(book.getDescription());	
//		return book;
//	}
	
//======== OR ========	
	
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		System.out.println(book.getId());
		System.out.println(book.getTitle());
		System.out.println(book.getDescription());	
		return new ResponseEntity<>(book, HttpStatus.CREATED);
	}

//====================================================================================


//	@RequestMapping(value = "/books/update/{id}", method = RequestMethod.PUT)
//	{id} is a URI template variable
	
//@PathVariable annotation is used to bind the template
//variable to method argument
	
//@RequestBody is used to convert the incoming JSON 
//into to a Java book object	
@PutMapping(value = "/books/update/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
		System.out.println(id);
		System.out.println(updatedBook.getTitle());
		System.out.println(updatedBook.getDescription());
		updatedBook.setId(id);
		return ResponseEntity.ok(updatedBook);
	}

//====================================================================================

//@RequestMapping(value = "/books/delete/{id}", method = RequestMethod.DELETE)

@DeleteMapping(value = "/books/delete/{id}")
public ResponseEntity<String> deleteBook(@PathVariable int id) {
	return ResponseEntity.ok("Book deleted successfully!");
}
	
	
}
