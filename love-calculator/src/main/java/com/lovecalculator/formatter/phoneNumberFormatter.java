package com.lovecalculator.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.lovecalculator.DTO.Phone;

public class phoneNumberFormatter implements Formatter<Phone> {

	@Override
	public String print(Phone object, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}
// here we are using formatter to format the phone number string in to phone object by using this interface 
//	In this interface we have two methods parse and print 
//	pare is used to convert the incoming string to phone object this formatter is check first before adding data to DTO
//	First it will check the formatter and then it will add the result to DTO with all other fields
//	We are configuring this formatter in configuration class implementing WebMvcConfig interface and overriding the method
//	when application get start it will first execute the configuration class
	
	@Override
	public Phone parse(String phoneNumberWithCountryCode, Locale locale) throws ParseException {
		
		String[] phoneDetails = phoneNumberWithCountryCode.split("-");
		
//		After splitting the phone number with country code we will add it to phone object and return to the 
//		communication class for phone variable
		Phone phone =new Phone();
		phone.setCountryCode(phoneDetails[0]);
		if(phoneDetails.length==1) {
		phone.setMobileNumber("");
		}
		else {
			phone.setMobileNumber(phoneDetails[1]);
		}
		
		
		return phone;
	}
	
	

}
