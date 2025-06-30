package tacos.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.Data;
import tacos.User;

//SUMMARY
//This class represents the form data submitted during user registration and 
//helps convert it into a User entity that can be saved to the database

//1) Lombok Annotation
//Automatically generates getters, setters, toString(), equals(), and hashCode()
@Data
public class RegistrationForm {
	
//2) Fields
//These fields match the input fields in the registration form 
//	(e.g., HTML form inputs)	
	private String username;
	private String password;
	private String fullname;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String phone;

//3) Method
//Converts the registration form data into a User object.
//Encrypts the password using the given PasswordEncoder (e.g., BCrypt).
//Returns a new User instance that is ready to be persisted	
	public User toUser(PasswordEncoder passwordEncoder) {
		return new User(
				username, 
				passwordEncoder.encode(password), 
				fullname, 
				street, 
				city, 
				state, 
				zip, 
				phone);
	}
}
