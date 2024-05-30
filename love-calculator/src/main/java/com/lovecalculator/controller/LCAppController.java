package com.lovecalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lovecalculator.DTO.UserInfoDTO;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("userInfo") //sessionAttribute name and modelAttribute names must be same 
public class LCAppController {
	
	@RequestMapping("/")
	public String welcomePage( Model model) {
		
		model.addAttribute("userInfo", new UserInfoDTO());
		
//		System.out.println(userInfoDTO);
		return "Home";
	}
	
	@RequestMapping("processData") // we must write @Valid at before @ModelAttribute and BindidngResult after DTO obj
	public String processData(@Valid @ModelAttribute ("userInfo") UserInfoDTO userInfo, BindingResult bindingResult) {
		
		
				
		 System.out.println(userInfo);
		 System.out.println(bindingResult.hasErrors());
		 if(bindingResult.hasErrors()) {
			 return "Home";
		 }
		return "processData";
		
	}
	

}
