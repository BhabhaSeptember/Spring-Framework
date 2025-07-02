package net.javaguides.springannotations;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.springannotations.controller.MyController;
import net.javaguides.springannotations.controller.PizzaController;
import net.javaguides.springannotations.lazy.LazyLoader;
import net.javaguides.springannotations.repository.MyRepository;
import net.javaguides.springannotations.service.MyService;
import net.javaguides.springannotations.service.VegPizza;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

//==================== ANNOTATION BASED CONFIGURATION ==================== 	

//		var context = SpringApplication.run(Application.class, args);

//EXAMPLE 1:		
//		PizzaController pizzaController = context.getBean(PizzaController.class);
		
//EXAMPLE 2:		
//		PizzaController pizzaController = (PizzaController) context.getBean("pizzaDemo");
		
//EXAMPLE 3:	
//		PizzaController pizzaController = (PizzaController) context.getBean("pizzaController");

//		System.out.println(pizzaController.getPizza());
	
		
//==================== JAVA BASED CONFIGURATION ==================== 	

//		var context = SpringApplication.run(Application.class, args);

//EXAMPLE 1:		
//		VegPizza vegPizza = context.getBean(VegPizza.class);
		
//EXAMPLE 2: 		
//		VegPizza vegPizza = (VegPizza) context.getBean("vegPizzaBean");

//EXAMPLE 3:
//		VegPizza vegPizza = (VegPizza) context.getBean("vegPizza");

//		System.out.println(vegPizza.getPizza());
		
//EXAMPLE 4:		
//		PizzaController pizzaController = (PizzaController) context.getBean("pizzaController");
//
//		System.out.println(pizzaController.getPizza());
	
//======================= STEREOTYPE ANNOTATIONS ====================		
		
//		var context = SpringApplication.run(Application.class, args);
//	
//		MyController myController = context.getBean(MyController.class);
//		System.out.println(myController.hello());
//
//		
//		MyService myService = context.getBean(MyService.class);
//		System.out.println(myService.hello());
//		
//		MyRepository myRepository = context.getBean(MyRepository.class);
//		System.out.println(myRepository.hello());
		
//========================= LAZY ANNOTATION ====================		

		var context = SpringApplication.run(Application.class, args);

		LazyLoader lazyLoader = context.getBean(LazyLoader.class);
	}
	
}
