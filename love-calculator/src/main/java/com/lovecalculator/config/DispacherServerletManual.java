package com.lovecalculator.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class DispacherServerletManual //implements WebApplicationInitializer
{

	//@Override
	public void onStartup(ServletContext servletContext) throws ServletException 
	//This is a manual process of creating the Dispacher servlet  and here we are commenting this Interface and
	// @Override annotation by which this manual dispacher servlet is created
	{
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
		annotationConfigWebApplicationContext.register(LoveCalculatorConfig.class);
		
		DispatcherServlet servlet = new DispatcherServlet(annotationConfigWebApplicationContext);
		
		ServletRegistration.Dynamic myDispacher= servletContext.addServlet("myDispactherServlet", servlet);
		myDispacher.addMapping("/daya/*");
		myDispacher.setLoadOnStartup(1);
		
		
	}

}
