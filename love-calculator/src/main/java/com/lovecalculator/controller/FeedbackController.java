package com.lovecalculator.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovecalculator.DTO.UserFeedBack;
import com.lovecalculator.service.FeedbackServiceImpl;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class FeedbackController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackController.class);
	
	@Autowired
	FeedbackServiceImpl feedbackServiceImpl;

	@RequestMapping("feedback")
	public String feedback(@ModelAttribute("userFeedback") UserFeedBack userfeed, HttpSession session) {
		String genderAndName = (String) session.getAttribute("genderAndName");
		String userEmail=(String) session.getAttribute("userEmail");
		LOGGER.info("User Name with gender indentity Information from session " + genderAndName);
		// by getting session
		userfeed.setUserName(genderAndName);
		userfeed.setUserEmail(userEmail);

		return "feedbackForm";

	}

	@RequestMapping("submitFeedback")
	public String submitFeedback(@Valid @ModelAttribute("userFeedback") UserFeedBack userfeed, BindingResult result) {
		LOGGER.info("Inside submitFeedback method");
		if (result.hasErrors()) {
			LOGGER.error("Error inside submitFeedback Method");
			List<FieldError> fieldErrors = result.getFieldErrors();
			for (FieldError error : fieldErrors) {
				LOGGER.error(error.getField() + " " + error.getDefaultMessage() + " " + error);
			}
			return "feedbackForm";
		}
		LOGGER.info("User feedback is recevied in side submitFeedback method");
		
		String pageResult=feedbackServiceImpl.feedProccess(userfeed.getUserName(), userfeed.getUserEmail(), userfeed.getFeedbackMessage());
		
		return pageResult;

	}

}
