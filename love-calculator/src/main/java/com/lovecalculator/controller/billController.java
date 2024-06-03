package com.lovecalculator.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovecalculator.DTO.Amount;
import com.lovecalculator.DTO.Bill;
import com.lovecalculator.DTO.CreditCard;
import com.lovecalculator.customeditors.AmountEditor;

import jakarta.validation.Valid;

@Controller
public class billController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LCAppController.class);
	@RequestMapping("bill")
	public String billPage(@ModelAttribute ("billInfo") Bill bill) {
		CreditCard card= new CreditCard();
		LOGGER.info("Inside bill Controller and inside billPage method");
		card.setFirstFourDigits(1111);
		card.setSecondFourDigits(2222);
		card.setThirdFourDigits(3333);
		card.setFourthFourDigits(4444);
		bill.setCreditCard(card);
		LOGGER.info("Sample card is shared to JSP page "+card);
		return "bill";
	}
	
	@RequestMapping("billDetails")
	public String billDetails(@Valid @ModelAttribute ("billInfo") Bill bill, BindingResult bindingResult) {
		LOGGER.info("Inside bill Controller and inside billDetails method");
		LOGGER.info("Bill:"+bill);
		if(bindingResult.hasErrors()) {
			LOGGER.error("Having error while geting bill object data from JSP.");
			LOGGER.error("Unsatisfied user Information provided");
			return "bill";
		}
		return "billDetails";
	}
	
	
	
	
	
	@InitBinder
	public void initBinding(WebDataBinder binder) {
		//first the string format date will come here and then it will get formatted here in date editor and then
		//sent to particular controller
		//form->InitBinding method->controller method
		SimpleDateFormat dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		CustomDateEditor customDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, "date", customDateEditor);
		
		//Here this is for amount with custom editor
	//Editor and formatter are same we define formatter at configuration class and editor at controller class
		AmountEditor amountEditor =new AmountEditor();
//		CustomNumberEditor customNumberEditor = new CustomNumberEditor(Integer.class,amountEditor, true);
		binder.registerCustomEditor(Amount.class,"amount", amountEditor);
		
		
		
	}

}