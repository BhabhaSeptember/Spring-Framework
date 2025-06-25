package tacos.data;

import org.springframework.data.repository.CrudRepository;

import tacos.User;

//SUMMARY
//This code defines a Spring Data JPA repository interface for managing User entities
//This interface allows us to:
//a)Persist and retrieve users from a database.
//b)Support login by providing findByUsername() for Spring Security.


//1)Interface Declaration
//This interface extends CrudRepository, meaning it automatically inherits methods like:
//a) save(User user)
//b) findById(Long id)
//c) findAll()
//d) deleteById(Long id)
//
//The generics <User, Long> tell Spring it’s working with User entities and
//The primary key (id) is of type Long
public interface UserRepository extends CrudRepository<User, Long> {
	
//2)Custom Query Method
//Custom finder method that tells Spring Data to generate a query:
//SQL: SELECT * FROM User WHERE username = ?
//This allows Spring Security to look up a user by their username during login	
	 User findByUsername(String username);

}
