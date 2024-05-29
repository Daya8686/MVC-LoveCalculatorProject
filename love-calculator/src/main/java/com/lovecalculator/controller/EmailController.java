package com.lovecalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovecalculator.DTO.EmailDTO;

import jakarta.validation.Valid;

@Controller
public class EmailController {
	
	@RequestMapping("sendEmail")
	public String emailPage(@ModelAttribute("emailDTO") EmailDTO emailDTO, Model model) {
		
		return "SendEmail";
		
	}
	@RequestMapping("emailSent")
	public String emailSuccess(@Valid @ModelAttribute("emailDTO")EmailDTO emailDTO, BindingResult result) {
		if(result.hasErrors()) {
			return "SendEmail";
		}
		
		return "emailSuccess";
		
	}

}
