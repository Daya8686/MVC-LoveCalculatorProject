package com.lovecalculator.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispacherServeltAutoConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
	 Class [] config= {LoveCalculatorConfig.class};
		return config;
	}

	@Override
	protected String[] getServletMappings() {
		String [] map= {"/"};
		return map;
	}

}
