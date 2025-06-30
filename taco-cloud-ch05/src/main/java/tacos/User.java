package tacos;

import java.util.Arrays;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

//NOTES: 
//This User type is different to the User from in-memory user details service
//It implements the UserDetails interface from Spring Security to provide user info
//to the framework e.g. authorities granted and user account enabled 
//


//SUMMARY
//This class represents a user in the database. The code defines a User entity class 
//for a Spring Boot application that integrates with Spring Security. 
//It also implements the UserDetails interface, 
//which Spring Security uses for authentication and authorization.

//1)Entity Setup
//@Entity: Maps this class to a database table
@Entity

//2)Lombok annotations:
//@Data: Generates getters, setters, toString, hashCode, etc.
//@NoArgsConstructor: Generates a private no-argument constructor (required by JPA).
//@RequiredArgsConstructor: Generates a constructor for all final fields 
//(used to populate user data)
@Data
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@RequiredArgsConstructor
@Table(name = "users")
public class User implements UserDetails {

//3)Fields and Identity
//Primary key id is auto-generated	
//All other fields (username, password, fullname, etc.) are final, meaning they are 
//required when constructing the object	
	 private static final long serialVersionUID = 1L;
	 
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Long id;
	  private final String username;
	  private final String password;
	  private final String fullname;
	  private final String street;
	  private final String city;
	  private final String state;
	  private final String zip;
	  private final String phoneNumber;
	  
//Method returns a collection indicating that all users will be granted ROLE_USER 
//authority	 
	  
//4)Implements UserDetails Interface
//Spring Security uses UserDetails to authenticate and authorize users	
//	  
//a)Authorities
//Every user is given a default role: ROLE_USER	  
	  @Override
	  public Collection<? extends GrantedAuthority> getAuthorities() {
	    return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	  }
	  
//b)Account Status Methods
//All these return true, which means:
//The account is not expired
//The account is not locked
//The credentials are not expired
//The account is enabled	  
	  @Override
	  public boolean isAccountNonExpired() {
	    return true;
	  }
	  
	  @Override
	  public boolean isAccountNonLocked() {
	    return true;
	  }
	  
	  @Override
	  public boolean isCredentialsNonExpired() {
	    return true;
	  }
	  
	  @Override
	  public boolean isEnabled() {
	    return true;
	  }
}
