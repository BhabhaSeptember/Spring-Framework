//================== ANNOTATION BASED CONFIGURATION ===========================

//package net.javaguides.springannotations.controller;
//
//import org.springframework.stereotype.Component;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//
//import net.javaguides.springannotations.service.Pizza;
//import net.javaguides.springannotations.service.VegPizza;
//
////NOTES: The @Component annotation indicates that an annotated class
////is a 'spring bean/component'
////It tells Spring container to automatically create Spring bean
//
////EXAMPLE 1:
//@Component //annotation based configuration
//
////EXAMPLE 2: 
////@Component("pizzaDemo") //annotation based configuration
//
////EXAMPLE 3: 
////@Component //annotation based configuration
//public class PizzaController {
//	
//	
////NOTES: The @Autowired annotation is used to inject the bean automatically	
////It is used in:
////a) Constructor injection
////b) Setter injection
////c) Field injection
//	
////EXAMPLE 1: FIELD INJECTION
////	@Autowired //annotation based configuration
////	private VegPizza vegPizza;
//	
//	private Pizza pizza;
//	
////EXAMPLE 2: CONSTRUCTOR INJECTION
////	@Autowired //annotation based configuration
////	public PizzaController(VegPizza vegPizza) {
////		this.vegPizza = vegPizza;
////	}
//	
//	
////@Qualifier annotation is used in conjunction with Autowired
////to avoid confusion when we have two or more beans
////configured for same type e.g. two implementations
////of an interface	
////	@Autowired //annotation based configuration
////	public PizzaController(@Qualifier("nonVegPizza") Pizza pizza) {
////		this.pizza = pizza;
////	}
//	
//	
////@Primary annotation Example:	
//	@Autowired //annotation based configuration
//	public PizzaController(Pizza pizza) {
//		this.pizza = pizza;
//	}
//
////EXAMPLE 3: SETTER INJECTION
////	@Autowired //annotation based configuration
////	public void setVegPizza(VegPizza vegPizza) {
////		this.vegPizza = vegPizza;
////	}
//
//	
//	public String getPizza() {
////		return "Hot Pizza!";
//
////		return vegPizza.getPizza();
//		
//		return pizza.getPizza();
//	}
//
//}

//================== JAVA BASED CONFIGURATION ===========================

package net.javaguides.springannotations.controller;

import net.javaguides.springannotations.service.Pizza;

public class PizzaController {

	private Pizza pizza;

	public PizzaController(Pizza pizza) {
		this.pizza = pizza;
	}

	public String getPizza() {
		return pizza.getPizza();
	}
	
	public void init() {
		System.out.println("Initialization Logic");
	}

	public void destroy() {
		System.out.println("Destruction Logic");
	}
	
}