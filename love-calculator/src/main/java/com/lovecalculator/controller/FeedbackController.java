package com.lovecalculator.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovecalculator.DTO.UserFeedBack;

import jakarta.validation.Valid;

@Controller
public class FeedbackController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(billController.class);

	@RequestMapping("feedback")
	public String feedback( @ModelAttribute("userFeedback") UserFeedBack userfeed) {
		
		return "feedbackForm";
		
	}
	@RequestMapping("submitFeedback")
	public String submitFeedback(@Valid @ModelAttribute("userFeedback") UserFeedBack userfeed, BindingResult result ) {
		LOGGER.info("Inside submitFeedback method");
		if(result.hasErrors()) {
			LOGGER.error("Error inside submitFeedback Method");
			List<FieldError> fieldErrors = result.getFieldErrors();
			for(FieldError error: fieldErrors) {
				LOGGER.error(error.getField()+" "+ error.getDefaultMessage()+" "+error);
			}
			return "feedbackForm";
		}
		return "submitedFeedback";
		
	}
	
}
