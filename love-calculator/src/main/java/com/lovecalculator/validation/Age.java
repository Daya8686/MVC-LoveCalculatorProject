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
@Constraint(validatedBy = AgeValidationConstraint.class)
public @interface Age {
	
	String message() default "The age must be from {lower} to {upper}";
	int lower() default 18;
	int upper() default 99;
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
