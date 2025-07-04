package tacos.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//SUMMARY:
//This class configures Spring MVC by registering a simple view controller
//to handle root ("/") requests without needing a dedicated controller 
//method
//This config file is a shortcut for routing static views 
//(like the homepage) without creating a full controller class. 
//It's a clean and efficient way to serve simple pages.
//
//
@Configuration
//Interface defines methods for configuring Spring MVC
public class WebConfig implements WebMvcConfigurer{
	
//Overriding a method from our interface
//Pass object to method parameter to register view controllers	
	 @Override
	 public void addViewControllers(ViewControllerRegistry registry) {
//Call method on registry object and pass route that the view,
//controller will use to handle GET requests and returns:
//ViewControllerRegistration object		 
		 registry.addViewController("/")
//Call method on returned object to specify the view that a,
//request to '/' should be forwarded to		 
		 .setViewName("home");
	}

}
