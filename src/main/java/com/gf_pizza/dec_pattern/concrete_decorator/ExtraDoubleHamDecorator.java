package com.gf_pizza.dec_pattern.concrete_decorator;

import com.gf_pizza.dec_pattern.component.Consummation;
import com.gf_pizza.dec_pattern.decorator.ExtraAdditionDecorator;

public class ExtraDoubleHamDecorator extends ExtraAdditionDecorator {

	public ExtraDoubleHamDecorator(Consummation consumation) {
		this.consumation = consumation;
	}
	
	@Override
	public String getName() {
		return consumation.getName() + "+ double Ham ";
	}
	
	@Override
	public double getKcal() {
		return consumation.getKcal() + 600;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return consumation.getPrice() + 1.90;
	}

	public String toString() {
		return "Pizza [name=" + this.getName() + ", kcal=" + this.getKcal() + ", Price=" + String.format("%.2f", this.getPrice()) + "€ ]";
	}
	
}
