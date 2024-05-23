package com.lovecalculator.converter;

import org.springframework.core.convert.converter.Converter;

import com.lovecalculator.DTO.CreditCard;

//This is for two way data binding by which we are showing the db 
//result with converter same like formatter and editor in this 
//formatter and editor we have print() and getAsValue()
public class CreditCardCoverterFromObjToString implements Converter<CreditCard, String> {

	@Override
	public String convert(CreditCard source) {
		//Spring will send this object data to converter method as we are using object as type 
		//source in implemented method and we are registering this method inside AsFormatter method
		
		String sample="Sample input: "+source.getFirstFourDigits()+"-"+source.getSecondFourDigits()+"-"+source.getThirdFourDigits()+
				"-"+source.getFourthFourDigits();
		
		return sample;
		
	}

}
