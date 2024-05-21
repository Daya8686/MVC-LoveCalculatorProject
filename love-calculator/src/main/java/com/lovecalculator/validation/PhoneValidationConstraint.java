package com.lovecalculator.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidationConstraint implements ConstraintValidator<PhoneCheck, String>{

	private int length;
	
	
	@Override
	public void initialize(PhoneCheck phone) {
		this.length=phone.length(); //this length method which is written in side a phone annotation
		
	}
	
	
	@Override
	public boolean isValid(String mobileNumber, ConstraintValidatorContext context) {
		
		
		System.out.println(mobileNumber);
		if(mobileNumber==null) {
			return false;
		}
		if( mobileNumber.matches("\\d{10}")) {
			if(length==mobileNumber.length() ) {
				return true;
			}
			
		}
		
		
		
		return false;
	}

}
