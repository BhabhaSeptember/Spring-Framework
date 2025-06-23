package tacos;

//Import lombok library which automatically generates at compile-time:
//getter&setter methods, equals(), hashCode() and toString() methods
import lombok.Data;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

//Annotation at class level is provided by Lombok, for Lombok to
//generate all missing methods & a constructor that takes all final,
//properties as arguments
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient implements Persistable<String> {

	@Id
	private  String id;
	private  String name;
	private  Type type;
	
//Overriding the interface abstract method	
	  @Override
		public boolean isNew() {
			return true;
		}

	public enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}

}
