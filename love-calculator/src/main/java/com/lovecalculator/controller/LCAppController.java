package com.lovecalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovecalculator.DTO.SignUpInfoDTO;
import com.lovecalculator.DTO.UserInfoDTO;

@Controller
public class LCAppController {
	
	@RequestMapping("/")
	public String welcomePage(@ModelAttribute("userInfoDefault") UserInfoDTO userInfoDTO) {
		
		return "Home";
	}
	
	@RequestMapping("processData")
	public String processData(@ModelAttribute ("userInfo") UserInfoDTO userInfo) {
		 
		return "processData";
		
	}
	@RequestMapping("signup")
	public String loginPage(@ModelAttribute("loginInfo") SignUpInfoDTO loginInfoDTO) {
		return "SignUp";
	}
	
	@RequestMapping("signupCheck")
	public String loginCheckPage(@ModelAttribute("loginInfo") SignUpInfoDTO loginInfoDTO) {
		System.out.println(loginInfoDTO);
		return "signupCheck";
		
	}

}
