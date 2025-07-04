package tacos;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;
import java.util.List;
import java.util.ArrayList;
import lombok.Data;

//SUMMARY: 
//This Java class defines a TacoOrder domain model used for placing taco 
//orders in a taco ordering application
//The TacoOrder class is a form-backed object that captures and validates:
//Delivery details, Credit card info and Selected tacos
//It's designed to work seamlessly with Spring MVC form validation and 
//ensures that every order is valid before being processed


@Data 
public class TacoOrder { 
	
//@NotBlank annotation ensures fields are filled in and 
//provides helpful message for user 
	@NotBlank(message="Delivery name is required")
	  private String deliveryName;
	
	@NotBlank(message="Street is required")
	  private String deliveryStreet;
	
	 @NotBlank(message="City is required")
	  private String deliveryCity;
	 
	 @NotBlank(message="State is required")
	  private String deliveryState;
	 
	 @NotBlank(message="Zip code is required")
	  private String deliveryZip;
	 
//Ensure valid credit card number according to Luhn algorithm	 
	 @CreditCardNumber(message="Not a valid credit card number")
	  private String ccNumber;
	 
//Ensure expiration is in MM/YY format	 
	 @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
			   message="Must be formatted MM/YY")
	  private String ccExpiration;
	 
//Ensure CVV is 3 digits long	 
	 @Digits(integer=3, fraction=0, message="Invalid CVV")
	  private String ccCVV;
	  
//Declare and instantiate a List of Taco objects   
	  private List<Taco> tacos = new ArrayList<>();
	  
//Add method takes a Taco object as parameter and adds it to,
//the list of Taco objects in ArrayList above
	  public void addTaco(Taco taco) {
	    this.tacos.add(taco);
	  }

}
