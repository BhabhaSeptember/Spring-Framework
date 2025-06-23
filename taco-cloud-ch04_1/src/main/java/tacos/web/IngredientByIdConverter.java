package tacos.web;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.Ingredient;
import tacos.data.IngredientRepository;


@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

	 private IngredientRepository ingredientRepo;


//	 @Autowired
	  public IngredientByIdConverter(IngredientRepository ingredientRepo) {
	    this.ingredientRepo = ingredientRepo;
	  }

	
	@Override
	public Ingredient convert(String id) {
		 return ingredientRepo.findById(id).orElse(null);
	}

}


//SUMMARY: 
//IngredientRepository is injected via the constructor 
//(no need for @Autowired since there's only one constructor).
//
//Uses ingredientRepo.findById(id) to look up the corresponding Ingredient.
//Returns the found ingredient or null if not found.


