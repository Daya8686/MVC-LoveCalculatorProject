package com.lovecalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovecalculator.DTO.Bill;

import jakarta.validation.Valid;

@Controller
public class billController {
	
	@RequestMapping("bill")
	public String billPage(@ModelAttribute ("billInfo") Bill bill) {
		return "bill";
	}
	
	@RequestMapping("billDetails")
	public String billDetails(@Valid @ModelAttribute ("billInfo") Bill bill, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "bill";
		}
		return "billDetails";
	}

}