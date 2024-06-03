package com.lovecalculator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LCAppController.class);
	
	@RequestMapping("sendEmail")
	public String emailPage(@SessionAttribute("userInfo") UserInfoDTO userInfo, @ModelAttribute("emailDTO") EmailDTO emailDTO, Model model) {
		String gender = userInfo.getGender();
		LOGGER.info("Inside Email Controller inside emailPage method");
		LOGGER.info("Gender is "+gender);
		String genderIdentity;
		if(gender.equals("Male")) {
			genderIdentity="Mr.";
		}
		else {
			genderIdentity="Ms.";
		}
		model.addAttribute("userGender",genderIdentity);
		LOGGER.info("GenderIdentity is "+genderIdentity);
		return "SendEmail";
		
	}
	@RequestMapping("emailSent")
	public String emailSuccess( @Valid @ModelAttribute("emailDTO")EmailDTO emailDTO, BindingResult result,@SessionAttribute("userInfo") UserInfoDTO userInfo, Model model) {
		LOGGER.info("Inside Email contoller and inside emailSuccess method");
		if(result.hasErrors()) {
			LOGGER.error("EmailDTO has error because information sent from JSP is not satisfied with validation");
			return "SendEmail";
		}
		String gender = userInfo.getGender();
		LOGGER.info("Gender is "+gender);
		String genderIdentity;
		if(gender.equals("Male")) {
			genderIdentity="Mr.";
		}
		else {
			genderIdentity="Ms.";
		}
		model.addAttribute("userGender",genderIdentity);
		LOGGER.info("GenderIdentity is "+genderIdentity);
		return "emailSuccess";
		
	}

}
