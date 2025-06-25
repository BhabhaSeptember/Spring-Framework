package tacos;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
//Designates this class as a JPA entity
@Entity
public class Taco {

//JPA entity persistence id	
	@Id
//To allow the database to automatically generate an ID for us	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Date createdAt = new Date();

	@NotNull
	@Size(min = 5, message = "Name must be at least 5 characters long")
	private String name;

	@NotNull
	@Size(min = 1, message = "You must choose at least 1 ingredient")
//Annotation declares the relationship between Taco and its associated,
//Ingredient list. i.e. A Taco can have many Ingredient objects, and,
//an Ingredient can be associated with many Taco objects	
	@ManyToMany()
	private List<Ingredient> ingredients = new ArrayList<>();

	public void addIngredient(Ingredient ingredient) {
		this.ingredients.add(ingredient);
	}

}
