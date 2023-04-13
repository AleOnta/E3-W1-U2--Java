package com.gf_pizza.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.gf_pizza.dec_pattern.component.Consummation;
import com.gf_pizza.dec_pattern.concrete_component.*;
import com.gf_pizza.dec_pattern.concrete_decorator.*;
import com.gf_pizza.restaurant.E_OrderStatus;
import com.gf_pizza.restaurant.E_TableStatus;
import com.gf_pizza.restaurant.Order;
import com.gf_pizza.restaurant.Table;

@Configuration
public class MenuConfiguration {
	
	// pizza beans
	
	@Bean
	@Scope("prototype")
	public Consummation margherita() {
		return new ConcretePizza();
	}
	
	@Bean
	@Scope("prototype")
	public Consummation large(Consummation consumation) {
		return new ExtraLargeDecorator(consumation);
	}
		
	@Bean
	@Scope("prototype")
	public Consummation ham(Consummation consumation) {
		return new ExtraHamDecorator(consumation);
	}
	
	@Bean
	@Scope("prototype")
	public Consummation doubleHam(Consummation consumation) {
		return new ExtraDoubleHamDecorator(consumation);
	}
	
	@Bean
	@Scope("prototype")
	public Consummation mushrooms(Consummation consumation) {
		return new ExtraMushroomsDecorator(consumation);
	}
	
	@Bean
	@Scope("prototype")
	public Consummation ananas(Consummation consumation) {
		return new ExtraAnanasDecorator(consumation);
	}
	
	// drink beans
	
	@Bean
	@Scope("prototype")
	public Consummation still_water() {
		return new ConcreteDrink(E_ConcreteDrink.STILL_WATER);
	}
	
	@Bean
	@Scope("prototype")
	public Consummation sparkling_water() {
		return new ConcreteDrink(E_ConcreteDrink.SPARKLING_WATER);
	}
	
	@Bean
	@Scope("prototype")
	public Consummation coca_cola() {
		return new ConcreteDrink(E_ConcreteDrink.COCA_COLA);
	}
	
	@Bean
	@Scope("prototype")
	public Consummation the() {
		return new ConcreteDrink(E_ConcreteDrink.THE);
	}
	
	@Bean
	@Scope("prototype")
	public Consummation beer() {
		return new ConcreteDrink(E_ConcreteDrink.BEER);
	}
	
	@Bean
	@Scope("prototype") 
	public Table table(int maxCovers) {
		return new Table(maxCovers, E_TableStatus.AVAILABLE);
	}
	
	@Bean
	@Scope("prototype")
	public Order order(Table t, int covers, List<Consummation> ordered) {
		return new Order(t, E_OrderStatus.RUNNING, covers, ordered);
	}
	
}
