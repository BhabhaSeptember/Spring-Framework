package tacos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;


import lombok.Data;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;

@Data
//Annotation below declares this class as a JPA entity
//JPA will automatically determine if this is a new entity or an update of,
//existing entity
@Entity
//Annotation below makes it easy to create an Ingredient object with all,
//properties initialized
@AllArgsConstructor
//Annotation below specifies that Lombok create a no-args constructor for us
//To prevent use, we set access level to private
//For 'final' properties to be set we set 'force' to true so Lombok generated,
//constructor will have default values or null/0/false
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
//@RequiredArgsConstructor
public class Ingredient {

//Annotation uniquely identifies this entity (note the package is a JPA variety)	
	@Id
	private  String id;
	private  String name;
	
	@Enumerated(EnumType.STRING)
	private  Type type;

	public enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}

}
