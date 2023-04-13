package com.gf_pizza.dec_pattern.decorator;

import com.gf_pizza.dec_pattern.component.Consummation;

public abstract class ExtraAdditionDecorator extends Consummation {

	protected Consummation consumation;
	
	@Override
	public abstract String getName();

}
