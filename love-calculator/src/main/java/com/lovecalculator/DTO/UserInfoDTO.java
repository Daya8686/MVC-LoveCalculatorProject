package com.lovecalculator.DTO;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserInfoDTO {
	
	@NotBlank(message = "* Your Name can not be left blank")
	@Size(min = 3, max = 25, message = "* Your Name feld must contains min 3 and max 25 charaters")
	private String yourName;
	
	@NotBlank(message = "* Your Gender must be selected!")
	private String gender;
	
	@NotBlank(message = "* Crush Name can not be left blank")
	@Size(min = 3, max = 25, message = "* Your Name feld must contains min 3 and max 25 charaters")
	private String crushName;
	
	@AssertTrue(message = "* Must accept the terms and condition to proceed")
	private boolean termsAndCondition;
	
	private String relationResult;
	
	
	public boolean isTermsAndCondition() {
		return termsAndCondition;
	}
	public void setTermsAndCondition(boolean termsAndCondition) {
		this.termsAndCondition = termsAndCondition;
	}
	public String getYourName() {
		return yourName;
	}
	public void setYourName(String yourName) {
		this.yourName = yourName;
	}
	public String getCrushName() {
		return crushName;
	}
	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRelationResult() {
		return relationResult;
	}
	public void setRelationResult(String relationResult) {
		this.relationResult = relationResult;
	}
	@Override
	public String toString() {
		return "UserInfoDTO [yourName=" + yourName + ", gender=" + gender + ", crushName=" + crushName
				+ ", termsAndCondition=" + termsAndCondition + ", relationResult=" + relationResult + "]";
	}
	
	
	
	
	
	
}
