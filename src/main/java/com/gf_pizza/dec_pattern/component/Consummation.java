package com.gf_pizza.dec_pattern.component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Consummation {
	
	protected String name = "";
	protected double kcal = 0;
	
	public abstract double getPrice();
	
	
}
