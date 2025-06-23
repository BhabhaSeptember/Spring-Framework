package tacos.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//import org.springframework.beans.factory.annotation.Autowired;

import tacos.Ingredient;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

	private JdbcTemplate jdbcTemplate;

//Spring injects object with jdbcTemplate i.e. autowires through constructor
	public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

//OVERRIDING INTERFACE METHODS
	
//syntax of jdbcTemplate's query method:
//query(SQL query, Spring's RowMapper, list of parameters needed in query)	
	
	@Override
	public Iterable<Ingredient> findAll() {
		return jdbcTemplate
				.query("select id, name, type from Ingredient", 
						this::mapRowToIngredient);
	}

	@Override
	public Optional<Ingredient> findById(String id) {
		List<Ingredient> results = jdbcTemplate
				.query("select id, name, type from Ingredient where id=?",
				this::mapRowToIngredient, id);
		return results.size() == 0 ? Optional.empty() : Optional.of(results.get(0));
	}

	private Ingredient mapRowToIngredient(ResultSet row, int rowNum) 
			throws SQLException {
		return new Ingredient(row.getString("id"), row.getString("name"),
				Ingredient.Type.valueOf(row.getString("type")));
	}
	
	
	 @Override
	 public Ingredient save(Ingredient ingredient) {
	  jdbcTemplate.update(
	      "insert into Ingredient (id, name, type) values (?, ?, ?)",
	      ingredient.getId(),
	      ingredient.getName(),
	      ingredient.getType().toString());
	  return ingredient;
	 }
}


//SUMMARY
//This class is a JDBC-based repository for the Ingredient entity
//A Spring @Repository bean that implements the IngredientRepository interface.
//Responsible for interacting with the database using JDBC to handle 
//Ingredient entities. Uses Spring’s JdbcTemplate to run SQL queries.
//
//JdbcTemplate is injected by Spring via constructor injection.
//No need for @Autowired since there’s only one constructor
//
//Interface Method Implementations
//1. findAll();
//Runs a SQL query to get all ingredients.
//Uses a method reference this::mapRowToIngredient to convert each database row 
//to an Ingredient object.
//
//2. findById(String id);
//Runs a parameterized SQL query to find one ingredient by ID.
//Returns an Optional<Ingredient>: empty if not found, or 
//the ingredient if found.
//
//3. save(Ingredient ingredient);
//Executes an INSERT SQL statement to save a new ingredient to the database.
//Returns the saved Ingredient
//
//Helper Method: mapRowToIngredient
//Converts a row from the result set into an Ingredient object.
//Extracts the id, name, and type columns.

