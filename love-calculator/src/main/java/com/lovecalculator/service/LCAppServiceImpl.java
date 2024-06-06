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
		System.out.println("-------------------------------------------->"+result);
		String finalResult="No Result found";
		switch(result) {
		case 'F':
			finalResult="Friends";
			break;
		case 'L':
			finalResult="Love";
			break;
		case 'A':
			finalResult="Affection";
			break;
		case 'M':
			finalResult="Marriage";
			break;
		case 'E':
			finalResult="Enemies";
			break;
		case 'S':
			finalResult="Sister";
			break;
		default :
			finalResult="No Result found";
			
		}
		
		return finalResult;
	}

}
