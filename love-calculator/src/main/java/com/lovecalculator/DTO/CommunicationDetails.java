package com.lovecalculator.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public class CommunicationDetails {
	
	@NotBlank(message = "Email feild can't be left blank")
	private String email;
	
	@Valid
	private Phone phone;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "CommunicationDetails [email=" + email + ", phone=" + phone + "]";
	}
	
	
	

}
