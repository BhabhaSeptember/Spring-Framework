package tacos;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;

//SUMMARY:
//This Java class defines a Taco domain model used in a taco ordering 
//application.
//This class models a Taco with a name and a list of selected ingredients. 
//It uses Jakarta Bean Validation annotations to ensure required data is 
//provided and meets minimum size requirements.
//
//
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
