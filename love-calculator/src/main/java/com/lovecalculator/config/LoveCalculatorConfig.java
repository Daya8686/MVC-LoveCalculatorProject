package com.lovecalculator.config;

import java.util.Properties;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.lovecalculator.converter.CreditCardConverter;
import com.lovecalculator.converter.CreditCardCoverterFromObjToString;
import com.lovecalculator.formatter.phoneNumberFormatter;

@Configuration
@ComponentScan(basePackages = "com")
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
	public MessageSource messageSource() {
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
	
	@Bean
	public JavaMailSenderImpl getJavaMailSender() {
		JavaMailSenderImpl javaMailSenderImpl =new JavaMailSenderImpl();
		javaMailSenderImpl.setHost("smtp.gmail.com");
		javaMailSenderImpl.setUsername("dhondidaya8080@gmail.com");
		javaMailSenderImpl.setPassword("bgag qttk bvoe dgas");
		javaMailSenderImpl.setPort(587);
		javaMailSenderImpl.setJavaMailProperties(gmailProperties());
		return javaMailSenderImpl;
		
	}
	public Properties gmailProperties() {
		Properties properties =new Properties();
		properties.put(	"mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		return properties;
	}
	

	@Override
	public Validator getValidator() {
		return validator();
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new phoneNumberFormatter());
//		registry.addFormatter(new CreditCardFormatter()); //Commenting this for using converter instead Converter
//		registry.addFormatter(new AmountFormatter()); // here we are using Custom Editor
		registry.addConverter(new CreditCardConverter()); // this is for String to CreditCard Object
		registry.addConverter(new CreditCardCoverterFromObjToString()); // this is for CreditCard Object to String to
																		// display
//		registry.addConverter(new CurrencyConverter()); // This is amount converter from eur ->EUR toUppercase
	}

}
