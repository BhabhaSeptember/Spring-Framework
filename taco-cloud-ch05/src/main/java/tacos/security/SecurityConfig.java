package tacos.security;

import java.util.*;



import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.authority.SimpleGrantedAuthority; //in-memory User class
//import org.springframework.security.provisioning.InMemoryUserDetailsManager; //in-memory User class
//import org.springframework.security.core.userdetails.UserDetails; //in-memory User class
//import org.springframework.security.core.userdetails.User; //in-memory User class

import tacos.data.UserRepository; //JPA UserDetailsService example
import tacos.User; //JPA UserDetailsService example
import org.springframework.security.core.userdetails.UsernameNotFoundException; //JPA UserDetailsService example


//SUMMARY
//The SecurityConfig class defines a Spring-managed bean that provides password 
//encryption using BCrypt. 
//This ensures user passwords are safely hashed and can be verified securely during 
//login

//Mark this class as a configuration class, allowing Spring to register beans 
//defined inside it
@Configuration
public class SecurityConfig {

//Declare a PasswordEncoder bean
//Returns an instance of BCryptPasswordEncoder, which is a secure hashing function used
//to encode passwords before storing them	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//NOTES:
//Configuring a user store to handle more than one user	
//The UserDetailsService interface, has one method: 'loadUserbyUsername(String username)'	
//The method takes a username then looks for a corresponding UserDetails object	
//In-memory user details service requires rebuilding & re-deploying the application if
//changes are made to user store (e.g. add, remove or update user)	
//It's best used for testing or small applications where users are not likely to change	

//--------------------------------- IN-MEMORY USER DETAILS SERVICE -----------------------------------	
//SUMMARY
//This code defines a Spring bean that configures in-memory user authentication using
//UserDetailsService
//The bean registers two users (buzz and woody) for authentication.
//Stores the users in memory (not in a database).
//Encodes their passwords for security.
//Assigns both the ROLE_USER authority.	

//1)Declare a Spring @Bean that returns a UserDetailsService	
//It uses a PasswordEncoder (BCryptPasswordEncoder) to encode passwords	
//	@Bean
//	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//		
////2)Create a list to hold multiple user accounts		
//		List<UserDetails> usersList = new ArrayList<>();
//		
////3)Add a user named buzz with:
////Password: "password" (encoded)
////Role: ROLE_USER		
//		usersList.add(
//				new User("buzz", 
//						encoder.encode("password"), 
//						Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
//		
////4)Add another user named woody with:
////Password: "password2" (encoded)
////Same role: ROLE_USER		
//		usersList.add(
//				new User("woody", 
//						encoder.encode("password2"), 
//						Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
//		
////5)Returns an InMemoryUserDetailsManager initialized with both users		
//		return new InMemoryUserDetailsManager(usersList);
//	}
//	

//--------------------------------- JPA USER DETAILS SERVICE -----------------------------------	

	@Bean
	public UserDetailsService userDetailsService(UserRepository userRepo) {
		return username -> {
			User user = userRepo.findByUsername(username);
			if (user != null)
				return user;
			throw new UsernameNotFoundException("User '" + username + "' not found");
		};
	}

}
