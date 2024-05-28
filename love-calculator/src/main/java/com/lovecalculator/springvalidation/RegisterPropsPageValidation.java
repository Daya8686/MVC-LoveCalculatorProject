package com.lovecalculator.springvalidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lovecalculator.DTO.SignUpInfoDTO;

public class RegisterPropsPageValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
// Here we write the class on which property we are going to validate we are comparing the class with parameter clazz
		
		return SignUpInfoDTO.class.equals(clazz); //checking dto class with parameter class
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "UserNameInvalid", "UserName should not be null");
		
		String userName = ((SignUpInfoDTO)obj).getUserName();
		if(!userName.contains("_")) {
			errors.rejectValue("userName", "userNameFormatInvalid", "UserName Must contains atleast one '_'.");
		}
		
		String usernamePattern = "^(?!_+$)(?!\\s+$)[A-Za-z0-9_]*[A-Za-z][A-Za-z0-9_]*$";
        
        // Compile the pattern
		
        Pattern pattern = Pattern.compile(usernamePattern);
        Matcher matcher=pattern.matcher(userName);
		if(!matcher.matches() || userName.length()<3) {
			errors.rejectValue("userName", "userNameFormatInvalid", "Invalid UserName!!");
		}
		
		
		String email=((SignUpInfoDTO)obj).getCommunicationDetails().getEmail();
		String emailPattern = "^[a-zA-Z0-9._%+-]+@seliniumExpress\\.com$";
		 Pattern pattern2 = Pattern.compile(emailPattern);
		 Matcher matcher2=pattern2.matcher(email);
		 if(!matcher2.matches()) {
			 errors.rejectValue("communicationDetails.email", "userEmailFormatInvalid");
			 // proving error message in property file with this key userEmailFormatInvalid --This is key 
		 }
		
	}

}
