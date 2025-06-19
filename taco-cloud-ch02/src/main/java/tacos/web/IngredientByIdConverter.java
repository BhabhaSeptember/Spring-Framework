package tacos.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.Ingredient;
import tacos.Ingredient.Type;

//Annotation denotes the class is a component and allows, 
//Spring application context to create a bean of it
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

	private Map<String, Ingredient> ingredientMap = new HashMap<>();

//Constructor creates a Map with:
//key = ingredient ID String
//value = Ingredient object	
	public IngredientByIdConverter() {
		ingredientMap.put("FLTO", new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
		ingredientMap.put("COTO", new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
		ingredientMap.put("GRBF", new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
		ingredientMap.put("CARN", new Ingredient("CARN", "Carnitas", Type.PROTEIN));
		ingredientMap.put("TMTO", new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
		ingredientMap.put("LETC", new Ingredient("LETC", "Lettuce", Type.VEGGIES));
		ingredientMap.put("CHED", new Ingredient("CHED", "Cheddar", Type.CHEESE));
		ingredientMap.put("JACK", new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
		ingredientMap.put("SLSA", new Ingredient("SLSA", "Salsa", Type.SAUCE));
		ingredientMap.put("SRCR", new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
	}

//Overridden convert method takes ingredient ID String and
//returns the Ingredient object from the map	
	@Override
	public Ingredient convert(String id) {
		return ingredientMap.get(id);
	}

}
