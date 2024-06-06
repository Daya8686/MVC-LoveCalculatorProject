package com.lovecalculator.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lovecalculator.DTO.UserInfoDTO;
import com.lovecalculator.service.LCAppServiceImpl;

import jakarta.validation.Valid;


@Controller
@SessionAttributes({"userInfo","RelationResult"}) // sessionAttribute name and modelAttribute names must be same
public class LCAppController {
	
	@Autowired
	private LCAppServiceImpl lcAppServiceImpl;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LCAppController.class);

	@RequestMapping("/")
	public String welcomePage(Model model) {

		model.addAttribute("userInfo", new UserInfoDTO());
		LOGGER.info("Inside the LCAppController insdie the welcomePage method");
		
		
//		System.out.println(userInfoDTO);
		return "Home";
	}

	@RequestMapping("processData") // we must write @Valid at before @ModelAttribute and BindidngResult after DTO	// obj
	public String processData(@Valid @ModelAttribute("userInfo") UserInfoDTO userInfo, BindingResult bindingResult, Model model) {
		
		LOGGER.info("Inside the processData method after welcomePage method in LCAppContoller");		
		LOGGER.trace("Having issue in processData method"+bindingResult.hasErrors());
		if (bindingResult.hasErrors()) {
			LOGGER.error("Having error while geting UserInfoDTO object data from JSP.");
			LOGGER.error("Unsatisfied user Information provided");
			return "Home";
		}
		String loveCalculationResult = lcAppServiceImpl.LoveCalculationCalculator(userInfo.getYourName(), userInfo.getCrushName());
		model.addAttribute("RelationResult", loveCalculationResult);
		
		return "processData";

	}

}
