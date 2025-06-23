package tacos;

//A Java domain class the defines a domain object we need for this application
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
