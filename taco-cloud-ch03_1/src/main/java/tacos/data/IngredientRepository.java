package tacos.data;

import java.util.Optional;

import tacos.Ingredient;

//SUMMARY
//This code defines a repository interface for managing Ingredient 
//objects in a Spring application
//This is a Spring Data-style repository that abstracts away the 
//database logic.
//It's used in services or controllers to interact with ingredient 
//data in a clean and testable way.

public interface IngredientRepository {

	Iterable<Ingredient> findAll();

	Optional<Ingredient> findById(String id);

	Ingredient save(Ingredient ingredient);

}

//SUMMARY
//This is a repository interface — a design used to abstract database operations,
//for Ingredient objects.
//
//1. Iterable<Ingredient> findAll();
//Purpose: Fetches all ingredients from the data source (e.g., database).
//
//Returns: An iterable collection of Ingredient objects.
//
//2. Optional<Ingredient> findById(String id);
//Purpose: Finds a single ingredient by its ID.
//
//Returns: An Optional<Ingredient>, which will contain the ingredient if found, 
//or be empty if not.
//
//3. Ingredient save(Ingredient ingredient);
//Purpose: Saves or updates an ingredient in the data source.
//
//Returns: The saved Ingredient object, often including generated values like
//a database ID.
