package com.gf_pizza.dec_pattern.concrete_decorator;

import com.gf_pizza.dec_pattern.component.Consummation;
import com.gf_pizza.dec_pattern.decorator.ExtraAdditionDecorator;

public class ExtraAnanasDecorator extends ExtraAdditionDecorator {
	
	public ExtraAnanasDecorator(Consummation consummation) {
		super(consummation);
	}

	@Override
	public String getName() {
		return consummation.getName() + "+ ananas ";
	}
	
	@Override
	public double getKcal() {
		return consummation.getKcal() + 200;
	}
	
	@Override
	public double getPrice() {
		return consummation.getPrice() + 0.90;
	}

	public String toString() {
		return "Pizza [name=" + this.getName() + ", kcal=" + this.getKcal() + ", Price=" + String.format("%.2f", this.getPrice()) + "€ ]";
	}
}
