package tacos.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.data.UserRepository;

//SUMMARY:
//This Spring MVC controller handles user registration in a web application

//1) Class Setup
//Marks the class as a Spring MVC controller.
//Maps requests starting with /register to this controller
@Controller
@RequestMapping("/register")
public class RegistrationController {
	
//2) Dependencies
//UserRepository: Used to save the user to the database.
//PasswordEncoder: Used to hash the password securely (e.g., BCrypt)	
	private UserRepository userRepo;
	private PasswordEncoder passwordEncoder;

//3) The above dependencies are injected via the constructor	
	public RegistrationController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}

//4) GET '/register'
//Displays the registration form (renders registration.html view)	
	@GetMapping
	public String registerForm() {
		return "registration";
	}

//5) POST '/register'
//Receives form data via a RegistrationForm object.
//Converts the form to a User object using form.toUser(passwordEncoder).
//Saves the new user to the database.
//Redirects to the login page (/login) after successful registration	
	@PostMapping
	public String processRegistration(RegistrationForm form) {
		userRepo.save(form.toUser(passwordEncoder));
		return "redirect:/login";
	}
}