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

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
@SessionAttributes({"cookiesTest"}) // sessionAttribute name and modelAttribute names must be same
public class LCAppController {
	
	@Autowired
	private LCAppServiceImpl lcAppServiceImpl;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LCAppController.class);

	@RequestMapping("/")
	public String welcomePage(Model model) {

		model.addAttribute("userInfo", new UserInfoDTO());
		model.addAttribute("cookiesTest","cookiesCheck"); //creating sample session for checking whether the user
//		disabled cookies or not 
		LOGGER.info("Inside the LCAppController insdie the welcomePage method");
		
		
//		System.out.println(userInfoDTO);
		return "Home";
	}

	@RequestMapping("processData") // we must write @Valid at before @ModelAttribute and BindidngResult after DTO obj
	public String processData(@Valid UserInfoDTO userInfo, BindingResult bindingResult, Model model,HttpSession session) {
		
//		Using both SessionAttributes and HttpSession because when we are not using @ModelAttribute in this class
//		Then the sessionAttributes we are unable to fetch data inside any
//		different controller by @SessionAttribute. HTTPSESSION AND SESSION THIS BOTH ARE DIFFERENT
		session.setAttribute("userInfo", userInfo);
		
		if(session.getAttribute("cookiesTest")==null) {
			return "enableCookies"; //after submitting this page it will check for cookies from session
			// if there is no cookies then it will send enableCookies page to user
		}
		model.addAttribute("userInfo", userInfo);
		model.addAttribute(BindingResult.MODEL_KEY_PREFIX+"userInfo", bindingResult);
		
		//If we want to persist userInfo with session then we need to write manually model and @Valid annotation
		//must be after DTO object and we need to add the error messages that must be displayed in JSP
		//By adding in side model by using this BindingResult.MODEL_KEY_PREFIX+"userInfo"
		
		LOGGER.info("Inside the processData method after welcomePage method in LCAppContoller");		
		LOGGER.trace("Having issue in processData method"+bindingResult.hasErrors());
		
		if (bindingResult.hasErrors()) {
			LOGGER.error("Having error while geting UserInfoDTO object data from JSP.");
			LOGGER.error("Unsatisfied user Information provided");
			return "Home";
		}
		
		String loveCalculationResult = lcAppServiceImpl.LoveCalculationCalculator(userInfo.getYourName(), userInfo.getCrushName());
		
		userInfo.setRelationResult(loveCalculationResult);
		
		return "processData";

	}

}
