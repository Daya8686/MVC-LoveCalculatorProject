package com.lovecalculator.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.lovecalculator.formatter.AmountFormatter;
import com.lovecalculator.formatter.CreditCardFormatter;
import com.lovecalculator.formatter.phoneNumberFormatter;

@Configuration
@ComponentScan (basePackages = "com")
@EnableWebMvc
public class LoveCalculatorConfig implements WebMvcConfigurer {
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/view/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
	
	@Bean
	public MessageSource messageSource(){
		ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
		bundleMessageSource.addBasenames("message");
		return bundleMessageSource;
		
	}
	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());
		return localValidatorFactoryBean;
	}
	
	
	@Override
	public Validator getValidator() {
		return validator();
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new phoneNumberFormatter());
		registry.addFormatter(new CreditCardFormatter());
		registry.addFormatter(new AmountFormatter());
	}
	
	

}
