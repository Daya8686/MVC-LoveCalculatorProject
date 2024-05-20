package com.lovecalculator.DTO;

public class CreditCard {
	
//	@Size(min = 4, max = 4, message = "First 4 digit must be present")
	private Integer firstFourDigits;
//	@Size(min = 4, max = 4, message = "Second 4 digit must be present")
	private Integer secondFourDigits;
//	@Size(min = 4, max = 4, message = "Third 4 digit must be present")
	private Integer thirdFourDigits;
//	@Size(min = 4, max = 4, message = "Fourth 4 digit must be present")
	private Integer fourthFourDigits;
	public Integer getFirstFourDigits() {
		return firstFourDigits;
	}
	public void setFirstFourDigits(Integer firstFourDigits) {
		this.firstFourDigits = firstFourDigits;
	}
	public Integer getSecondFourDigits() {
		return secondFourDigits;
	}
	public void setSecondFourDigits(Integer secondFourDigits) {
		this.secondFourDigits = secondFourDigits;
	}
	public Integer getThirdFourDigits() {
		return thirdFourDigits;
	}
	public void setThirdFourDigits(Integer thirdFourDigits) {
		this.thirdFourDigits = thirdFourDigits;
	}
	public Integer getFourthFourDigits() {
		return fourthFourDigits;
	}
	public void setFourthFourDigits(Integer fourthFourDigits) {
		this.fourthFourDigits = fourthFourDigits;
	}
	@Override
	public String toString() {
		return firstFourDigits+"-"+ secondFourDigits+"-"
				+  thirdFourDigits + "-"+ fourthFourDigits ;
	}
	
	
	
	

}
