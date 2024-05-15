package com.lovecalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovecalculator.DTO.UserInfoDTO;

@Controller
public class LCAppController {
	
	@RequestMapping("/")
	public String welcomePage(@ModelAttribute("userInfoDefault") UserInfoDTO userInfoDTO) {
		System.out.println(userInfoDTO);
		return "Home";
	}
	
	@RequestMapping("processData")
	public String processData(@ModelAttribute ("userInfo") UserInfoDTO userInfo) {
		 System.out.println(userInfo);
		return "processData";
		
	}
	

}
