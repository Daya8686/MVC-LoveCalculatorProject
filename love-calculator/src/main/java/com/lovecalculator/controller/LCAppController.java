package com.lovecalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovecalculator.DTO.UserInfoDTO;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
public class LCAppController {
	
	@RequestMapping("/")
	public String welcomePage(@ModelAttribute("userInfo") UserInfoDTO userInfoDTO) {
		System.out.println(userInfoDTO);
		return "Home";
	}
	
	@RequestMapping("processData") // we must write @Valid at before @ModelAttribute and BindidngResult after DTO obj
	public String processData(@Valid @ModelAttribute ("userInfo") UserInfoDTO userInfo, BindingResult bindingResult,HttpServletResponse request) {
		Cookie cookie =new Cookie("LCApp.userName", userInfo.getYourName());
		cookie.setMaxAge(60*60);
		request.addCookie(cookie);
				
		 System.out.println(userInfo);
		 System.out.println(bindingResult.hasErrors());
		 if(bindingResult.hasErrors()) {
			 return "Home";
		 }
		return "processData";
		
	}
	

}
