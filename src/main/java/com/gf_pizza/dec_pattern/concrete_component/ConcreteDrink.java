package com.gf_pizza.dec_pattern.concrete_component;

import com.gf_pizza.dec_pattern.component.Consummation;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ConcreteDrink extends Consummation {
	
	protected E_ConcreteDrink name;
	
	@Override
	public double getKcal() {
		if (name.equals(E_ConcreteDrink.SPARKLING_WATER) || name.equals(E_ConcreteDrink.STILL_WATER) || name.equals(E_ConcreteDrink.BEER)) {
			return 50;
		} else {
			return 300;
		}
	}	
	
	@Override
	public double getPrice() {
		if (name.equals(E_ConcreteDrink.SPARKLING_WATER) || name.equals(E_ConcreteDrink.SPARKLING_WATER)) {
			return 1.20;
		} else {
			return 2.50;
		}
	}

	public String toString() {
		return "Drink [name="+ name + ", kcal=" + this.getKcal() + ", price=" + String.format("%.2f", this.getPrice()) + "€]";
	}
	
}
