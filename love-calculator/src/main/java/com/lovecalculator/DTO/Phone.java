package com.lovecalculator.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Phone {
	
	@NotBlank(message = "country code can be blank")
	@Size(min = 1, max = 3, message = "country must be entered with country code as follows: Eg: 91-0000000000")
	private String countryCode;
	
	@NotBlank(message = "Phone number should not be left blank")
	@Size(min = 10, max = 10, message = "Phone number must be entered with country code as follows: Eg: 91-0000000000")
	private String mobileNumber;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "Phone [countryCode=" + countryCode + ", mobileNumber=" + mobileNumber + "]";
	}
	
	

}
