package com.lovecalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovecalculator.DTO.SignUpInfoDTO;

@Controller
public class UserRegistrationController {
	
	@RequestMapping("signup")
	public String loginPage(@ModelAttribute("signUpInfo") SignUpInfoDTO signUpInfoDTO) {
		return "SignUp";
	}
	
	@RequestMapping("signupCheck")
	public String loginCheckPage(@ModelAttribute("signUpInfo") SignUpInfoDTO signUpInfoDTO) {
		System.out.println(signUpInfoDTO);
		return "signupCheck";
		
	}

}
