package tacos.data;

import org.springframework.data.repository.*;

import tacos.Ingredient;

//OPTION 1: Class Declaration extends Repository interface provided by Spring Data
//This allows Spring Data to automatically generate implementations for,
//IngredientRepository at run time
//Repository interface is parameterized: 
//1) Ingredient = Object to be persisted by this repository
//2) String = Type of persisted object's ID field
//
//public interface IngredientRepository extends Repository<Ingredient, String> {
//
//OPTION 2: CrudRepository will automatically define the methods we need
	public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
