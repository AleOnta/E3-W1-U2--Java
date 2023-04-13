package com.gf_pizza.dec_pattern.concrete_component;

import com.gf_pizza.dec_pattern.component.Consummation;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class ConcretePizza extends Consummation {
	
	@Override
	public String getName() {
		return "Margherita ";
	}
	
	@Override
	public double getKcal() {
		return 700;
	}

	@Override
	public double getPrice() {
		return 6.50;
	}

	@Override
	public String toString() {
		return "Pizza [name=" + this.getName() + ", kcal=" + this.getKcal() + ", Price=" + String.format("%.2f", this.getPrice()) + "€ ]";
	}
}
