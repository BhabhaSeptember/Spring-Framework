package tacos;

//SUMMARY:
//This Java class defines a domain model called Ingredient used in a
//taco ordering application.
//This class models a single taco ingredient with an ID, name, and 
//type — useful for managing selections in a taco-building app.
//
//
//Domain = an application subject area i.e. ingredients

//Import lombok library which automatically generates at compile-time:
//getter&setter methods, equals(), hashCode() and toString() methods
import lombok.Data;


//Annotation at class level is provided by Lombok, for Lombok to
//generate all missing methods & a constructor that takes all final,
//properties as arguments
@Data
public class Ingredient {
	
//Three properties defined to describe an ingredient	
	  private final String id;
	  private final String name;
	  private final Type type;
	  
	  public enum Type {
	    WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	  }

}
