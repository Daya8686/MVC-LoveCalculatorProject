package com.lovecalculator.customeditors;

import java.beans.PropertyEditorSupport;

public class UsernameEditor extends PropertyEditorSupport{
		
	@Override
	public String getAsText() {
		return "Example username: Daya_8686"; 
		//here we can do two way data binding with formatters and also editors
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String res=text.toUpperCase();
		setValue(res);
	}

}
