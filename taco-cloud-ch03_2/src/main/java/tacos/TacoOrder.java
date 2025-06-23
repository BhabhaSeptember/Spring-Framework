package tacos;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.*;

import lombok.Data;

import java.io.Serializable;

@Data 
//Annotation below is optional. By default, the object is mapped to a table based on the,
//domain class name i.e. TacoOrder class is mapped to a table named Taco_Order
//We can specify a different target table with @Table("Taco_Cloud_Order")
@Table
public class TacoOrder implements Serializable { 
	
	  private static final long serialVersionUID = 1L;
	 
//Annotation below designates objects 'id' property	as being the identity for a TacoOrder
//All other properties are mapped automatically to columns based on their property name i.e.
//deliveryName property will be mapped to column named delivery_name
//To define a different target column we use e.g. : @Column("customer_name")	  
	  @Id
	  private Long id;
	  private Date placedAt;
	  
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
	  
	 @CreditCardNumber(message="Not a valid credit card number")
	  private String ccNumber;
	 	 
	 @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
			   message="Must be formatted MM/YY")
	  private String ccExpiration;
	  
	 @Digits(integer=3, fraction=0, message="Invalid CVV")
	  private String ccCVV;
	    
	  private List<Taco> tacos = new ArrayList<>();
	  
	  public void addTaco(Taco taco) {
	    this.tacos.add(taco);
	  }

}
