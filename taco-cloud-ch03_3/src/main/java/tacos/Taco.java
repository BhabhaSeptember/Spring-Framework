package tacos;

import java.util.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

//Annotation causes Lombok to automatically generate methods,
//and constructor
@Data
@Table
public class Taco {

	@Id
	private Long id;
	private Date createdAt = new Date();

	@NotNull
	@Size(min = 5, message = "Name must be at least 5 characters long")
	private String name;

	@NotNull
	@Size(min = 1, message = "You must choose at least 1 ingredient")
	private List<IngredientRef> ingredients = new ArrayList<>();

	public void addIngredient(Ingredient taco) {
		this.ingredients.add(new IngredientRef(taco.getId()));
	}

}
