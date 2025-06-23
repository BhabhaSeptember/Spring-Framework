package tacos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.*;

import lombok.Data;

import java.io.Serializable;

@Data 
@Entity
public class TacoOrder implements Serializable { 
	
	  private static final long serialVersionUID = 1L;
	 	  
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
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
	    
//Declaring the relationship between a TacoOrder and a Taco object.
//i.e. All Taco objects in the list are specific to one order or
//One TacoOrder has many Taco objects associated with it	
//Cascade attribute is set to allow a deletion of an order to delete all,
//related tacos	 
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinTable(
			  name = "TacoOrder_Tacos",
			  joinColumns = @JoinColumn(name = "taco_order_id"),
			  inverseJoinColumns = @JoinColumn(name = "taco_id")
			)
	  private List<Taco> tacos = new ArrayList<>();
	  
	  public void addTaco(Taco taco) {
	    this.tacos.add(taco);
	  }

}
