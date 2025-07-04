package tacos.data;

import tacos.TacoOrder;

//SUMMARY:
//This code defines a repository interface for managing TacoOrder 
//objects in a Spring application.
//This is a data access abstraction that allows the application to 
//persist taco orders without being tightly coupled to the storage 
//logic.

public interface OrderRepository {
	
	 TacoOrder save(TacoOrder order);

}
