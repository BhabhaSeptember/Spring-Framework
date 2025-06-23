package tacos.data;

import org.springframework.data.repository.*;

import tacos.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
	

}
