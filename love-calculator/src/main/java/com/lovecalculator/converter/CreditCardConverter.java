package com.lovecalculator.converter;

import org.springframework.core.convert.converter.Converter;

import com.lovecalculator.DTO.CreditCard;

public class CreditCardConverter implements Converter<String, CreditCard> {

	//Spring will send this object data to converter method as we are using String as type 
	//source in implemented method and we are registering this method inside AsFormatter method
	
	@Override
	public CreditCard convert(String source) { //This converter is same like formatter and 
		//editor and in this there is only one predefine method is 
		//there and we need to override it and then we need to implement 
		//the logic and this has only one method so we need to create another 
		//converter class for displaying the information as print and getAsText 
		//methods in formatter and editor respectively for two way data binding.
		
		//This converter method must be implemented in configuration class in 
		//AddConverter method and it will not work in initBinding
		CreditCard card= new CreditCard();
		String[] cardArr = source.split("-");
		if(source.startsWith("-")) {
			card.setFirstFourDigits(0);
			card.setSecondFourDigits(0);
			card.setThirdFourDigits(0);
			card.setFourthFourDigits(0);
			
		}
		else if(cardArr.length!=4 || source.length()!=19) {
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
