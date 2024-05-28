package com.lovecalculator.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = EmailValidationConstrains.class)
public @interface Email {
	
	String message() default "{GmailValidtionMessgae}";
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
