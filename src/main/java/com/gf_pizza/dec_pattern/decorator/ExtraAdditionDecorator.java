package com.gf_pizza.dec_pattern.decorator;

import com.gf_pizza.dec_pattern.component.Consummation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class ExtraAdditionDecorator extends Consummation {

	protected Consummation consummation;
	
	@Override
	public abstract String getName();

}
