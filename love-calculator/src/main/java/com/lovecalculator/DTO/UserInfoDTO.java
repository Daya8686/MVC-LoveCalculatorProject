package com.lovecalculator.DTO;

public class UserInfoDTO {
	
	private String yourName="Jack";
	private String crushName="Amy";
	private boolean termsAndCondition;
	
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
	@Override
	public String toString() {
		return "UserInfoDTO [yourName=" + yourName + ", crushName=" + crushName + ", termsAndCondition="
				+ termsAndCondition + "]";
	}
	
	
	
	
}
