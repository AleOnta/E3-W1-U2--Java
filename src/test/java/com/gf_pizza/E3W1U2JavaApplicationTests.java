package com.gf_pizza;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.gf_pizza.dec_pattern.component.Consummation;
import com.gf_pizza.dec_pattern.concrete_component.ConcreteDrink;
import com.gf_pizza.dec_pattern.concrete_component.ConcretePizza;
import com.gf_pizza.restaurant.E_OrderStatus;
import com.gf_pizza.restaurant.E_TableStatus;
import com.gf_pizza.restaurant.Order;
import com.gf_pizza.restaurant.Table;

@SpringBootTest
class E3W1U2JavaApplicationTests {

	private Order orderForTesting;
	
	@Test
	@BeforeEach
	public void orderSetUp() {
		Table table = new Table(5, E_TableStatus.AVAILABLE);
		
		orderForTesting = new Order();
		orderForTesting.setTableId(table.getTableId());
		orderForTesting.setStatus(E_OrderStatus.RUNNING);
		orderForTesting.setCovers(4);
		orderForTesting.setConsList(new ArrayList<Consummation>());
		
	}
	
	@Test
	public void addConsummation() {
		Consummation pizza = new ConcretePizza();
		
		orderForTesting.getConsList().add(pizza);
		assertEquals(orderForTesting.getConsList().size(), 1);
	}

}
