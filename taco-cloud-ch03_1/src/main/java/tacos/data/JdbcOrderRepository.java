package tacos.data;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//import org.springframework.asm.Type;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tacos.IngredientRef;
import tacos.Taco;
import tacos.TacoOrder;

@Repository
public class JdbcOrderRepository implements OrderRepository {

	private JdbcOperations jdbcOperations;

	public JdbcOrderRepository(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	@Override
	@Transactional
	public TacoOrder save(TacoOrder order) {
				
//Object describes the insert query plus the types of the query's input fields		
		PreparedStatementCreatorFactory pscf = 
				new PreparedStatementCreatorFactory(
				"insert into Taco_Order " 
				+ "(delivery_name, delivery_street, delivery_city, "
			    + "delivery_state, delivery_zip, cc_number, " 
				+ "cc_expiration, cc_cvv, placed_at) "
				+ "values (?,?,?,?,?,?,?,?,?)",
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP
				);
//Set to true so we can retrieve the generated order's ID		
		pscf.setReturnGeneratedKeys(true);
		
		order.setPlacedAt(new Date());
//Use pscf object above to create psc object below
//Pass in TacoOrder object values that must be saved		
		PreparedStatementCreator psc = 
				pscf.newPreparedStatementCreator(
						Arrays.asList(
								order.getDeliveryName(),
								order.getDeliveryStreet(), 
								order.getDeliveryCity(), 
								order.getDeliveryState(), 
								order.getDeliveryZip(),
								order.getCcNumber(), 
								order.getCcExpiration(), 
								order.getCcCVV(), 
								order.getPlacedAt()));
		
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		
//With psc object above, we use jdbcTemplates 'update()' method to save order data
//We pass in the PreparedStatementCreator and GeneratedKeyHolder object		
		jdbcOperations.update(psc, keyHolder);
		
//Retrieve the database generated ID for the saved order		
		long orderId = keyHolder.getKey().longValue();
//Copy the ID into TacoOrder objects id property		
		order.setId(orderId);
		
//Finally, save the tacos associated with the order		
		List<Taco> tacos = order.getTacos();
		int i = 0;
		for (Taco taco : tacos) {
			saveTaco(orderId, i++, taco);
		}
		
		return order;
	}
	
	
	
	
	 private long saveTaco(Long orderId, int orderKey, Taco taco) {
		 
		  taco.setCreatedAt(new Date());
		  
		  PreparedStatementCreatorFactory pscf =
		  new PreparedStatementCreatorFactory(
		      "insert into Taco "
		      + "(name, created_at, taco_order, taco_order_key) "
		      + "values (?, ?, ?, ?)",
		      Types.VARCHAR, Types.TIMESTAMP, Types.BIGINT, Types.BIGINT
		  );
		  pscf.setReturnGeneratedKeys(true);
		  
		  PreparedStatementCreator psc =
		      pscf.newPreparedStatementCreator(
		    	 Arrays.asList(
		    			 taco.getName(),
		    			 taco.getCreatedAt(),
		    			 orderId,
		    			 orderKey));
		  
		  GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		  jdbcOperations.update(psc, keyHolder);
		  long tacoId = keyHolder.getKey().longValue();
		  taco.setId(tacoId);
		  
		  saveIngredientRefs(tacoId, taco.getIngredients());
		  
		  return tacoId;
		 }
	 
//Link Taco row to an Ingredient row
	 private void saveIngredientRefs(
			 long tacoId, List<IngredientRef> ingredientRefs) {
		 
		 int key = 0;
		  for (IngredientRef ingredientRef : ingredientRefs) {
		    jdbcOperations.update(
		 "insert into Ingredient_Ref (ingredient, taco, taco_key) "
		 + "values (?, ?, ?)",
		 ingredientRef.getIngredient(), tacoId, key++);
		  }
		 }
	 }
	 


