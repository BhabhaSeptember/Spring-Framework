 package tacos;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.GetMapping;
 
//Annotation for Spring to identify class as component for component,
// scanning, i.e. create an instance of HomeController bean in Spring,
// application context
 @Controller           
public class HomeController {
	 
	 
//Annotation indicates that this method handles HTTP GET requests, 
// received for root path "/". Method returns String value of home view 
  @GetMapping("/")     
  public String home() {
	  return "home";
  }
 }