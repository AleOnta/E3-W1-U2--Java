package com.gf_pizza.dec_pattern.concrete_component;

import com.gf_pizza.dec_pattern.component.Consummation;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ConcretePizza extends Consummation {
	
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
		return "Pizza [name=" + name + ", kcal=" + this.getKcal() + ", Price=" + String.format("%.2f", this.getPrice()) + "€ ]";
	}

	
}
