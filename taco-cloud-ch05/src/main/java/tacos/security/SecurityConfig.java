package tacos.security;

import java.util.*;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
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

//SUMMARY:
//This code defines a Spring @Bean that provides a custom UserDetailsService 
//implementation for authentication using your database	

//This bean tells Spring Security how to load user details from your database
//using the UserRepository.
//How it works:
//1) The method receives a username.
//2) It uses userRepo.findByUsername(username) to fetch a User from the 
//database.
//3) If the user exists, it returns the User (which implements UserDetails).
//4) If the user does not exist, it throws a UsernameNotFoundException.
//Why it works:
//The method is a lambda-based implementation of the UserDetailsService 
//interface, which only requires one method: loadUserByUsername	
//When This Is Used:
//Spring Security will automatically use this bean when performing 
//authentication during login.	
	@Bean
	public UserDetailsService userDetailsService(UserRepository userRepo) {
		return username -> {
			User user = userRepo.findByUsername(username);
			if (user != null)
				return user;
			throw new UsernameNotFoundException("User '" + username + "' not found");
		};
	}

//SUMMARY
//This Spring Security configuration defines a SecurityFilterChain bean that
//controls access to different parts of the web application	
	
//What it does:
//1) Secures Specific URLs: "/design" and "/orders" are protected.
//Only users with the ROLE_USER can access them (i.e., authenticated users).
//2) Allows Public Access: The root URL ("/") and all other URLs ("/**") are
//accessible to everyone, even unauthenticated users
	
//NOTES: The requestMatchers(...).hasRole("USER") line ensures access is restricted 
//to users who have the "ROLE_USER" authority.
//The filterChain method accepts an HttpSecurity object, which acts as a 
//builder that can be used to configure how security is handled at the web 
//level. Once security configuration is set up via the HttpSecurity object, 
//a call to build() will create a SecurityFilterChain that is returned from 
//the bean method
//This method uses the modern lambda-based configuration, which is the 
//recommended approach for Spring Security 6+	
//
//
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/design", "/orders").hasRole("USER")
				.requestMatchers("/", "/**").permitAll()
				)
		.formLogin(form -> form.loginPage("/login")
				);
				return http.build();
	}
	

	

}
