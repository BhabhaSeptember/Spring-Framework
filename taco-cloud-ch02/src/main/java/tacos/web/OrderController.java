package tacos.web;

import jakarta.validation.Valid;
import org.springframework.validation.Errors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import lombok.extern.slf4j.Slf4j;
import tacos.TacoOrder;

//Annotation creates Logger object at compile-time
@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")

public class OrderController {

//=================== GETMAPPING METHOD ===================  	
//Method handles HTTP GET requests on route '/orders/current'	
	@GetMapping("/current")
	public String orderForm() {
//Return a view called 'orderForm'		
		return "orderForm";
	}
	
	
//=================== POSTMAPPING METHOD ===================  	
//Method handles POST requests on '/orders' route	
	@PostMapping
//Method takes TacoOrder object as argument whose properties,
//are bound to the submitted form fields	
	 public String processOrder(
			 @Valid TacoOrder order, Errors errors,
//Pass SessionStatus object as second argument of method			 
	 SessionStatus sessionStatus) {
		
		if (errors.hasErrors()) {
			return "orderForm";
		}
		
//Log the TacoOrder object	
	  log.info("Order submitted: {}", order);
//Call setComplete() method on SessionStatus object argument,
//to clear the session whereby a TacoOrder object had initially
//been created. (make ready for new order)	  
	  sessionStatus.setComplete();
	  return "redirect:/";
	 }

}
