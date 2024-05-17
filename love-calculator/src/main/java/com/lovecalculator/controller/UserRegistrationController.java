package com.lovecalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovecalculator.DTO.CommunicationDetails;
import com.lovecalculator.DTO.Phone;
import com.lovecalculator.DTO.SignUpInfoDTO;

import jakarta.validation.Valid;

@Controller
public class UserRegistrationController {

	@RequestMapping("signup")
	public String loginPage(@ModelAttribute("signUpInfo") SignUpInfoDTO signUpInfoDTO) {
		//we are using print method to send the string country code and mobile number by converting to phone object
		Phone phone = new Phone();
		phone.setCountryCode("91"); // ---> lets think this is coming from db but now hard coded 
		phone.setMobileNumber("9898989898");
		CommunicationDetails communicationDetails = new CommunicationDetails();
		communicationDetails.setPhone(phone);
		signUpInfoDTO.setCommunicationDetails(communicationDetails);
		return "SignUp";
	}

	@RequestMapping("signupCheck")
	public String loginCheckPage(@Valid @ModelAttribute("signUpInfo") SignUpInfoDTO signUpInfoDTO,BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			List <FieldError> errors = bindingResult.getFieldErrors();
//            for (FieldError error : errors) {
//                System.out.println("Error in field: " + error.getField() + " - " + error.getDefaultMessage());
//            }
//			
//			return "SignUp";
//		}
		System.out.println(signUpInfoDTO);
		return "signupCheck";

	}

}
