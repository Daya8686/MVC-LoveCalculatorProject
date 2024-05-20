package com.lovecalculator.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidationConstraint implements ConstraintValidator<Age, Integer> {

	private int lower;
	private int upper;
	
	
	@Override
	public void initialize(Age age) {
		this.lower=age.lower();
		this.upper=age.upper();
	}
	
	
	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		
		if(age<lower || age> upper) {
			return false;
		}
		
		
		return true;
	}

}
