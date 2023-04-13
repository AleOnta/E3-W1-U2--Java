package com.gf_pizza.dec_pattern.concrete_decorator;

import com.gf_pizza.dec_pattern.component.Consummation;
import com.gf_pizza.dec_pattern.decorator.ExtraAdditionDecorator;

public class ExtraHamDecorator extends ExtraAdditionDecorator {

	public ExtraHamDecorator(Consummation consumation) {
		this.consumation = consumation;
	}
	
	@Override
	public String getName() {
		return consumation.getName() + "+ Ham ";
	}

	@Override
	public double getKcal() {
		return consumation.getKcal() + 300;
	}
	
	@Override
	public double getPrice() {
		return consumation.getPrice() + 1.20;
	}

	public String toString() {
		return "Pizza [name=" + this.getName() + ", kcal=" + this.getKcal() + ", Price=" + String.format("%.2f", this.getPrice()) + "€ ]";
	}
	
}
