package com.lovecalculator.converter;

import org.springframework.core.convert.converter.Converter;

import com.lovecalculator.DTO.Amount;

public class CurrencyConverter implements Converter<String, Amount> {

	@Override
	public Amount convert(String amount) {
		 Amount convertedAmount = new Amount();
		    String[] amountArr = amount.split(" ");
		    String amountStr="";
		    String currency="";
		    if (amountArr.length == 2) {
		        amountStr = amountArr[0];
		        currency = amountArr[1].toUpperCase();
		        
		    }
		    convertedAmount.setBillAmount(Integer.parseInt(amountStr));
		    convertedAmount.setLocalDefination(currency);
		return convertedAmount;
	}

}
