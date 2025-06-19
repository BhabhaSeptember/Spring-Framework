package tacos;

import java.util.List;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

//Annotation causes Lombok to automatically generate methods,
//and constructor
@Data
public class Taco {

//Java domain object with two properties: name and ingredients
	
//Declare name property to not be null and length of at least 5	
	@NotNull
	@Size(min = 5, message = "Name must be at least 5 characters long")
	private String name;

	@NotNull
	@Size(min = 1, message = "You must choose at least 1 ingredient")
	private List<Ingredient> ingredients;

}
