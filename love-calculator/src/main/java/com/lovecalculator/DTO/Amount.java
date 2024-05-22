package com.lovecalculator.DTO;

public class Amount {
	
	
	private Integer billAmount;
	private String localDefination;
	public Integer getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(Integer billAmount) {
		this.billAmount = billAmount;
	}
	public String getLocalDefination() {
		return localDefination;
	}
	public void setLocalDefination(String localDefination) {
		this.localDefination = localDefination;
	}
	@Override
	public String toString() {
		System.out.println(billAmount+" "+ localDefination);
		return  localDefination +" "+ billAmount ;
	}
	

}
