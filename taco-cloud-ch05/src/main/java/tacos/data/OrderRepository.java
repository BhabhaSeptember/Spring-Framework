package tacos.data;

import org.springframework.data.repository.*;

import java.util.*;
import org.springframework.data.jpa.repository.Query;

import tacos.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
	
//EXAMPLES!!!	
//CrudRepository provides all CRUD methods but we can add our own	
//custom additional methods e.g. to find deliveries for a given zip code
	
//Spring Data examines each method in repository interface, parses the method name,
//and attempts to understand methods purpose in context of persisted objects.
//So, persistence details are expressed in repository method signatures
//
// 1)	
//Here, Spring Data knows the method is intended to find TacoOrders because,
//CrudRepository is parameterized with TacoOrder. Method name indicates that,
//this method should find all TacoOrder entities by matching their deliveryZip,
//property with the value passed in as a parameter to the method	
//
//	List<TacoOrder> findByDeliveryZip(String deliveryZip);
//	
// 2)	
//Custom method below finds orders delivered to a given zip code within a given date range	
//	 
//	List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween(
//		      String deliveryZip, Date startDate, Date endDate);
//	 
// 3)
//	//WILL FAIL AT RUNTIME
//	 List<TacoOrder> findByDeliveryToAndDeliveryCityAllIgnoresCase(
//			 String deliveryTo, String deliveryCity);
//	
// 4)	
//Sorts the results by specified column	 
//	
//	 List<TacoOrder> findByDeliveryCityOrderByDeliveryTo(String city);
//	
// 5)
//	
//Specify the query to be performed when method is called to simplify method signatures	 
//	 @Query("Order o where o.deliveryCity='Seattle'")
//	 List<TacoOrder> readOrdersDeliveredInSeattle();
//	 
	 
	 
}
