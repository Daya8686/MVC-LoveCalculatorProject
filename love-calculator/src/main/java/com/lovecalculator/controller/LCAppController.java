package com.lovecalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LCAppController {
	
	@RequestMapping("/")
	public String welcomePage() {
		return "Home";
	}
	
	@RequestMapping("processData")
	public String processData(@RequestParam("yourName") String yourName, @RequestParam ("crushName") String crushName, Model model) {
		System.out.println("-=-=-=-==-=-=-=-=-=-=-=-=-=--=-=-=-=-==-======-==-=--=-=--=-");
		System.out.println();
		 model.addAttribute("userName", yourName);
		 model.addAttribute("crushName", crushName);
		 
		return "processData";
		
	}

}
