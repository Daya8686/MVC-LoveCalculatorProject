package com.lovecalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.lovecalculator.DTO.EmailDTO;
import com.lovecalculator.DTO.UserInfoDTO;

import jakarta.validation.Valid;

@Controller
public class EmailController {
	
	@RequestMapping("sendEmail")
	public String emailPage(@SessionAttribute("userInfo") UserInfoDTO userInfo, @ModelAttribute("emailDTO") EmailDTO emailDTO, Model model) {
		String gender = userInfo.getGender();
		System.out.println(gender);
		String genderIdentity;
		if(gender.equals("Male")) {
			genderIdentity="Mr.";
		}
		else {
			genderIdentity="Ms.";
		}
		model.addAttribute("userGender",genderIdentity);
		return "SendEmail";
		
	}
	@RequestMapping("emailSent")
	public String emailSuccess( @Valid @ModelAttribute("emailDTO")EmailDTO emailDTO, BindingResult result,@SessionAttribute("userInfo") UserInfoDTO userInfo, Model model) {
		if(result.hasErrors()) {
			return "SendEmail";
		}
		String gender = userInfo.getGender();
		System.out.println(gender);
		String genderIdentity;
		if(gender.equals("Male")) {
			genderIdentity="Mr.";
		}
		else {
			genderIdentity="Ms.";
		}
		model.addAttribute("userGender",genderIdentity);
		
		return "emailSuccess";
		
	}

}
