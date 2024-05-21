package com.lovecalculator.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = PhoneValidationConstraint.class)
public @interface PhoneCheck {
	
	String message() default "{VaildPhoneNumberErrorMessage}";
	int length() default 10;
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
	
	

}
