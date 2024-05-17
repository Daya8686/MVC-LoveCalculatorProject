package com.lovecalculator.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.lovecalculator.DTO.Phone;

public class phoneNumberFormatter implements Formatter<Phone> {

	@Override
	public String print(Phone phone, Locale locale) {
		//This print is used when we are getting information from db we get it in the form of string and then we need to
		//convert to phone object by using this print method and return string
		
		return phone.getCountryCode()+"-"+phone.getMobileNumber();
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
		Phone phone = new Phone();
//		After splitting the phone number with country code we will add it to phone object and return to the 
//		communication class for phone variable
		if (phoneNumberWithCountryCode.contains("-") && phoneNumberWithCountryCode.indexOf('-') != 0) {
			phone.setCountryCode(phoneDetails[0]);
			phone.setMobileNumber(phoneDetails[1]);
		} else if (phoneNumberWithCountryCode.indexOf('-') == 0) {
			phone.setCountryCode("91");
			phone.setMobileNumber(phoneDetails[1]);
		} else {

			phone.setCountryCode("91");
			phone.setMobileNumber(phoneDetails[0]);
		}

		return phone;
	}

}
