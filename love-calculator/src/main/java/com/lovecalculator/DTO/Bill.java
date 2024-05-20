package com.lovecalculator.DTO;

public class Bill {
	
//	@Valid
//	@NotBlank(message = "Card details can't be black")
	private CreditCard creditCard;
	
	private Amount amount;

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

	@Override
	public String toString() {
		return "Bill [creditCard=" + creditCard + ", amount=" + amount + "]";
	}
	
	
}
