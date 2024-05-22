package com.lovecalculator.controller;

import java.util.List;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovecalculator.DTO.CommunicationDetails;
import com.lovecalculator.DTO.Phone;
import com.lovecalculator.DTO.SignUpInfoDTO;
import com.lovecalculator.customeditors.UsernameEditor;

import jakarta.validation.Valid;

@Controller
public class UserRegistrationController {

	@RequestMapping("signup")
	public String loginPage(@ModelAttribute("signUpInfo") SignUpInfoDTO signUpInfoDTO) {
		// we are using print method to send the string country code and mobile number
		// by converting to phone object
		Phone phone = new Phone();
		phone.setCountryCode("91"); // ---> lets think this is coming from db but now hard coded
		phone.setMobileNumber("9898989898");
		CommunicationDetails communicationDetails = new CommunicationDetails();
		communicationDetails.setPhone(phone); // print method from formatter is and perform formatting by spring
		signUpInfoDTO.setCommunicationDetails(communicationDetails);
		return "SignUp";
	}

	@RequestMapping("signupCheck")
	public String loginCheckPage(@Valid @ModelAttribute("signUpInfo") SignUpInfoDTO signUpInfoDTO,
			BindingResult bindingResult) {
		System.out.println(signUpInfoDTO);
		if (bindingResult.hasErrors()) {
			List <FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println("Error in field: " + error.getField() + " - " + error.getDefaultMessage());
            }
			
			return "SignUp";
		}
		System.out.println(signUpInfoDTO);
		return "signupCheck";

	}
	
	
//	We are using the Init Binding by which every time a controller is called first if we want to do any changes
//	before getting data to that controller we use this initBinding.
//	Before directly going to controller the it will first comes to this InitBinding and then it will send the 
//	Changed data to DTO of controller
	
	@InitBinder
	public void initBinder (WebDataBinder binder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true); 
		binder.registerCustomEditor(String.class, "name", stringTrimmerEditor); 
		//if we set true it gives null
		//	Else it will give if we set false then it will give "" empty string	
		// we have given @NotEmpty annotation in DTO object and user get error message when user send empty data
		// we user send blank spaces like this "    " then it will not give error message 
		//so here we can use this Databinder to bind the data in required eay and then send to DTO of controller
		UsernameEditor editor = new UsernameEditor();
		binder.registerCustomEditor(String.class,"userName", editor);
		
		
	}

}
