package net.javaguides.springannotations.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import net.javaguides.springannotations.controller.PizzaController;
import net.javaguides.springannotations.service.NonVegPizza;
import net.javaguides.springannotations.service.Pizza;
import net.javaguides.springannotations.service.VegPizza;

//NOTES: 
//With annotation based configuration, we used @Autowire
//annotation to inject the dependency automatically
//
//With java based configuration we explicitly provide
//the dependency to a class. Then we use @Bean annotation
//so Spring container can start managing the object of
//the class
@Configuration
//@Lazy
public class AppConfig {

//EXAMPLE 1:
//	@Bean
	
//EXAMPLE 2:
//	@Bean(name = "vegPizzaBean")
	
//EXAMPLE 3:	
	@Bean
//	@Lazy
	public Pizza vegPizza() {
		return new VegPizza();
	}

	
	@Bean
	public Pizza nonVegPizza() {
		return new NonVegPizza();
	}
	
//@Bean annotation methods:	
//a) initMethod called after bean is initialized run after the bean is 
//constructed and dependencies are injected, but before the bean is 
//available for use in the application context
//e.g.insert records in a database table at application
//startup	
//b) destroyMethod called before bean destruction
//e.g.delete records from database table during
//application shutdown	
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public PizzaController pizzaController() {
		return new PizzaController(nonVegPizza());	
		}
}
