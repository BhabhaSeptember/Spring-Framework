package tacos.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.Valid;
import org.springframework.validation.Errors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.Taco;
import tacos.TacoOrder;

//Annotation automatically generates a Logger static property in class
@Slf4j
//Identifies the class as a controller and marks it for component,
//scanning so Spring can create a bean in Spring application context
@Controller
//Indicate that this class handles requests whose path, 
//begins with '/design'
@RequestMapping("/design")
//Holds the session state of order being built as user creates,
//tacos across multiple requests
@SessionAttributes("tacoOrder")

public class DesignTacoController {

//Methods invoked when request is handled by class	

//Construct list of Ingredient objects using their constructor
//Method takes a Model object which carries data between,
//a controller and the view that must render the data
	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		List<Ingredient> ingredients = Arrays.asList(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
				new Ingredient("COTO", "Corn Tortilla", Type.WRAP), new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
				new Ingredient("CARN", "Carnitas", Type.PROTEIN),
				new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES), new Ingredient("LETC", "Lettuce", Type.VEGGIES),
				new Ingredient("CHED", "Cheddar", Type.CHEESE), new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
				new Ingredient("SLSA", "Salsa", Type.SAUCE), new Ingredient("SRCR", "Sour Cream", Type.SAUCE));

//Filter the list of ingredients by type using, 
//helper method: filterByType()	    
		Type[] types = Ingredient.Type.values();

		for (Type type : types) {
//adding list of ingredient types as an attribute to Model object,
//which will be passed into showDesignForm()	    	
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
		}

	}// end of addIngredientsToModel method

//Method creates tacoOrder object to place into model object
//	 
	@ModelAttribute(name = "tacoOrder")
	public TacoOrder order() {
		return new TacoOrder();
	}

//Populate model with empty taco object, so form will have new,
//empty taco object to create and design (avoid null display)	 
	@ModelAttribute(name = "taco")
	public Taco taco() {
		return new Taco();
	}

	
//=================== GETMAPPING METHOD ===================  
//Specify that Spring MVC will call showDesignForm() method to handle, 
//HTTP GET requests received for '/design' route (see @RequestMapping above)	  
	@GetMapping
	public String showDesignForm() {
//Method returns a view called 'design' to render model to browser		  
		return "design";
	}

//=================== POSTMAPPING METHOD ===================  	
//Annotation indicates the method that handles POST requests	
	 @PostMapping
//At form submission, form fields are bound to properties of,
//Taco object and passed as parameter to method below	 
	 public String processTaco(
			 
//@Valid annotation	tells Spring MVC to perform validation,
//on submitted Taco object after it's bound to submitted,
//form data & before the processTaco() method is called
//Errors are captured in the Errors object passed into method			 
			 @Valid Taco taco, Errors errors,
			 
//Annotation indicates to use TacoOrder object that was placed
//in order() method above			 
	    @ModelAttribute TacoOrder tacoOrder) {
		 
//hasErrors() method of Errors object checks for errors,
//and returns the design view form if errors found
//i.e. we break out of the method if validation fails		 
		 if (errors.hasErrors()) {
			 return "design";
		 }
		 
//Add Taco object to TacoOrder object passed as parameter,
//to this method 	
		 tacoOrder.addTaco(taco);
//Log the Taco object	  
	  log.info("Processing taco: {}", taco);
//Method returns a redirect view to the path specified	  
	  return "redirect:/orders/current";
	 }	

	 
//Helper method  
	private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		return ingredients
				.stream()
				.filter(x -> x.getType().equals(type))
				.collect(Collectors.toList());
	}
}
