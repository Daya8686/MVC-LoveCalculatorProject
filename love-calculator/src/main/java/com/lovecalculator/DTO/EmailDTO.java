package com.lovecalculator.DTO;

import com.lovecalculator.validation.Email;

public class EmailDTO {
	
	@Email
	private String userEmail;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "EmailDTO [userEmail=" + userEmail + "]";
	}
	

}
