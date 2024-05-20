package com.lovecalculator.formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.lovecalculator.DTO.Amount;

public class AmountFormatter implements Formatter<Amount> {

	@Override
	public String print(Amount object, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Amount parse(String amount, Locale locale) throws ParseException {
	    Amount convertedAmount = new Amount();
	    String[] amountArr = amount.split(" ");
	    if (amountArr.length == 2) {
	        String amountStr = amountArr[0];
	        String currency = amountArr[1];
	        try {
//	            double amountValue = Double.parseDouble(amountStr);
	            Locale currencyLocale = getLocalInstance(currency);
	            if (currencyLocale == null) {
	                throw new ParseException("Unsupported currency code.", 0);
	            }
	            Currency currencyChanger = Currency.getInstance(currency);
	            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(currencyLocale);
	            currencyFormat.setCurrency(currencyChanger);
//	            String formattedAmount = currencyFormat.format(amountValue);
//	            System.out.println(formattedAmount);
	            
	            String symbol = currencyChanger.getSymbol(currencyLocale);
	            convertedAmount.setBillAmount(Integer.parseInt(amountStr));
	            convertedAmount.setLocalDefination(symbol);
	            System.out.println(symbol);
	        } catch (NumberFormatException e) {
	            throw new ParseException("Invalid number format.", 0);
	        } catch (IllegalArgumentException e) {
	        	System.out.println("Unsupported currency code: " + currency);
	            throw new ParseException("Unsupported currency code.", 0);
	        }
	    } else {
	        throw new ParseException("Invalid number format.", 0);
	    }
	    return convertedAmount;
	}
	public static Locale getLocalInstance(String currency ) {
		switch (currency.toUpperCase()) {
        case "EUR":
            return Locale.GERMANY; // Germany uses Euro
        case "USD":
            return Locale.US; // United States Dollar
        case "GBP":
            return Locale.UK; // British Pound
        case "INR":
            return new Locale("en", "IN"); // Indian Rupee
        case "JPY":
            return Locale.JAPAN; // Japanese Yen
        case "CNY":
            return Locale.CHINA; // Chinese Yuan
        case "AUD":
            return new Locale("en", "AU"); // Australian Dollar
        case "CAD":
            return new Locale("en", "CA"); // Canadian Dollar
        case "CHF":
            return new Locale("de", "CH"); // Swiss Franc
        case "RUB":
            return new Locale("ru", "RU"); // Russian Ruble
        case "BRL":
            return new Locale("pt", "BR"); // Brazilian Real
        case "ZAR":
            return new Locale("en", "ZA"); // South African Rand
        case "KRW":
            return new Locale("ko", "KR"); // South Korean Won
        default:
            return null;
    }
		
	}

}
