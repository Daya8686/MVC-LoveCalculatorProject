package com.lovecalculator.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.lovecalculator.DTO.CreditCard;

public class CreditCardFormatter implements Formatter<CreditCard> {

	@Override
	public String print(CreditCard cardObj, Locale locale) {
		// TODO Auto-generated method stub
		
		return cardObj.getFirstFourDigits()+"-"+cardObj.getSecondFourDigits()+"-"+cardObj.getThirdFourDigits()+"-"+cardObj.getFourthFourDigits();
	}

	@Override
	public CreditCard parse(String cardNumber, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		CreditCard card= new CreditCard();
		String[] cardArr = cardNumber.split("-");
		if(cardNumber.startsWith("-")) {
			card.setFirstFourDigits(0);
			card.setSecondFourDigits(0);
			card.setThirdFourDigits(0);
			card.setFourthFourDigits(null);
			
		}
		else if(cardArr.length!=4 || cardNumber.length()!=19) {
				return null;
			}
		else {
			try {
				for(int i=0;i<cardArr.length;i++) {
					if(cardArr[i].length()==4) {
						card.setFirstFourDigits(Integer.parseInt(cardArr[0]));
						card.setSecondFourDigits(Integer.parseInt(cardArr[1]));
						card.setThirdFourDigits(Integer.parseInt(cardArr[2]));
						card.setFourthFourDigits(Integer.parseInt(cardArr[3]));
					}
				}
				
			}
			catch(NumberFormatException e) {
				System.out.println("Entered Credit Card number is Wrong");
			}
		}
			
		
		return card;
	}

}
