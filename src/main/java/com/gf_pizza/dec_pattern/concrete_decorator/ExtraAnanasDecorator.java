package com.gf_pizza.dec_pattern.concrete_decorator;

import com.gf_pizza.dec_pattern.component.Consummation;
import com.gf_pizza.dec_pattern.decorator.ExtraAdditionDecorator;

public class ExtraAnanasDecorator extends ExtraAdditionDecorator {

	public ExtraAnanasDecorator(Consummation consumation) {
		this.consumation = consumation;
	}
	
	@Override
	public String getName() {
		return consumation.getName() + "+ ananas ";
	}
	
	@Override
	public double getKcal() {
		return consumation.getKcal() + 200;
	}
	
	@Override
	public double getPrice() {
		return consumation.getPrice() + 0.90;
	}

	public String toString() {
		return "Pizza [name=" + this.getName() + ", kcal=" + this.getKcal() + ", Price=" + String.format("%.2f", this.getPrice()) + "€ ]";
	}
}
