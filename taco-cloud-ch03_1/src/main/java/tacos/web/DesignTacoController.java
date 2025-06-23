package tacos.web;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import jakarta.validation.Valid;
import org.springframework.validation.Errors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.Taco;
import tacos.TacoOrder;

import tacos.data.IngredientRepository;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")

public class DesignTacoController {

	private final IngredientRepository ingredientRepo;
	
//	  @Autowired
	public DesignTacoController(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}
	
	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		Iterable<Ingredient> ingredients = ingredientRepo.findAll();

		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
		}

	}

	@ModelAttribute(name = "tacoOrder")
	public TacoOrder order() {
		return new TacoOrder();
	}

	@ModelAttribute(name = "taco")
	public Taco taco() {
		return new Taco();
	}

	@GetMapping
	public String showDesignForm() {
		return "design";
	}

	@PostMapping
	public String processTaco(

			@Valid Taco taco, Errors errors,

			@ModelAttribute TacoOrder tacoOrder) {

		if (errors.hasErrors()) {
			return "design";
		}

		tacoOrder.addTaco(taco);

		log.info("Processing taco: {}", taco);

		return "redirect:/orders/current";
	}

//Helper method  
	private Iterable<Ingredient> filterByType(Iterable<Ingredient> ingredients, Type type) {
		return StreamSupport
				.stream(ingredients.spliterator(), false)
				.filter(i -> i.getType().equals(type))
				.collect(Collectors.toList());
	}
}

//SUMMARY
////Inject JdbcIngredientRepository  into DesignTacoController and use it to 
//provide a list of Ingredient objects instead of using hardcoded values
//
//The addIngredientsToModel() method uses the injected IngredientRepository’s
//findAll() method to fetch all ingredients from the database. 
//It then filters them into distinct ingredient types before adding them to 
//the model
//
