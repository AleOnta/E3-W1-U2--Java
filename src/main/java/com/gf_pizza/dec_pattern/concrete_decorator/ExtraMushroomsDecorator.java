package com.gf_pizza.dec_pattern.concrete_decorator;

import com.gf_pizza.dec_pattern.component.Consummation;
import com.gf_pizza.dec_pattern.decorator.ExtraAdditionDecorator;

public class ExtraMushroomsDecorator extends ExtraAdditionDecorator {

	public ExtraMushroomsDecorator(Consummation consummation) {
		super(consummation);
	}

	@Override
	public String getName() {
		return consummation.getName() + "+ mushrooms ";
	}

	@Override
	public double getKcal() {
		return consummation.getKcal() + 350;
	}
	
	@Override
	public double getPrice() {
		return consummation.getPrice() + 1.50;
	}

	public String toString() {
		return "Pizza [name=" + this.getName() + ", kcal=" + this.getKcal() + ", Price=" + String.format("%.2f", this.getPrice()) + "€ ]";
	}
	
}
