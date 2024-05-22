package com.lovecalculator.DTO;

import java.util.Date;

import jakarta.validation.constraints.Future;

public class Bill {
	
//	@Valid
//	@NotBlank(message = "Card details can't be black")
	private CreditCard creditCard;
	
	private Amount amount;
	
	
	@Future(message = "unable to select the past date")
	private Date date; //we are implementing the date dataBinding and for amount class on billAmount field

	
	
	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Bill [creditCard=" + creditCard + ", amount=" + amount + ", date=" + date + "]";
	}

	
	
}
