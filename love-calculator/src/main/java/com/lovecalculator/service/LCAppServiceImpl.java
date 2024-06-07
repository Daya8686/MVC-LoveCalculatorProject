package com.lovecalculator.service;

import org.springframework.stereotype.Service;

import com.lovecalculator.serviceinterfaces.LCAppService;

@Service
public class LCAppServiceImpl implements LCAppService {

	@Override
	public String LoveCalculationCalculator(String userName, String crushName) {
		final String formula="FLAMES";
		StringBuilder repeatingString= new StringBuilder();
		int bothNames=userName.length()+crushName.length();
		int repeatingStringTimes=bothNames/formula.length();
		int reminderNameValue=bothNames%formula.length();
				
		for (int i=0;i<repeatingStringTimes;i++) {
			repeatingString.append(formula);
		}
		repeatingString.append(formula.substring(0, reminderNameValue+1));
		
		char result=repeatingString.charAt(bothNames);
		
		String finalResult = relationFinder(result);
		
		return finalResult;
	}

	private String relationFinder(char result) {
		String finalResult="No Result found";
		switch(result) {
		case 'F':
			finalResult=Relations.F_Meaning_value;
			break;
		case 'L':
			finalResult=Relations.L_Meaning_value;
			break;
		case 'A':
			finalResult=Relations.A_Meaning_value;
			break;
		case 'M':
			finalResult=Relations.M_Meaning_value;
			break;
		case 'E':
			finalResult=Relations.E_Meaning_value;
			break;
		case 'S':
			finalResult=Relations.S_Meaning_value;
			break;
		default :
			finalResult="No Result found";
			
		}
		return finalResult;
	}

}
