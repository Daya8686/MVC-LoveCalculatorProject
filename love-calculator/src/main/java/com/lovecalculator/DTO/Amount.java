package com.lovecalculator.DTO;

public class Amount {
	
	private int billAmount;
	private String localDefination;
	public int getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(int billAmount) {
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
		return " localDefination"+" billAmount+";
	}
	

}
