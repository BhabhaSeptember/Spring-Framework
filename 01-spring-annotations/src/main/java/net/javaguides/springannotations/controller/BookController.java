package net.javaguides.springannotations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.javaguides.springannotations.beans.Book;

@Controller
public class BookController {
	
	@RequestMapping("/hello-world")
	@ResponseBody
	public String helloWorld() {
		return "Hello Book Controller";
	}
	
	@RequestMapping("/book")
	@ResponseBody
	public Book getBook(){
		Book book = new Book(1, "Core Java", "Learn Core Java & Latest Features");
		return book;
		
	}
	
}
