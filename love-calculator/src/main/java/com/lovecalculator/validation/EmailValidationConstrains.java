package com.lovecalculator.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidationConstrains implements ConstraintValidator<Email, String> {

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		String emailPattern = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
		 Pattern pattern2 = Pattern.compile(emailPattern);
		 Matcher matcher2=pattern2.matcher(email);
		return (matcher2.matches())?true:false;
		 
		
	}
	

}
