package com.lovecalculator.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovecalculator.DTO.SignUpInfoDTO;

import jakarta.validation.Valid;

@Controller
public class UserRegistrationController {

	@RequestMapping("signup")
	public String loginPage(@ModelAttribute("signUpInfo") SignUpInfoDTO signUpInfoDTO) {

		return "SignUp";
	}

	@RequestMapping("signupCheck")
	public String loginCheckPage(@Valid @ModelAttribute("signUpInfo") SignUpInfoDTO signUpInfoDTO,BindingResult bindingResult) {
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

}
