package com.lovecalculator.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
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
@PropertySource("classpath:email.properties")
public class LoveCalculatorConfig implements WebMvcConfigurer {

	@Autowired
	private Environment environment;
	
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
		javaMailSenderImpl.setHost(environment.getProperty("mail.host"));
		javaMailSenderImpl.setUsername(environment.getProperty("mail.username"));
		javaMailSenderImpl.setPassword(environment.getProperty("mail.password"));
		javaMailSenderImpl.setPort(Integer.parseInt(environment.getProperty("mail.port")));
		javaMailSenderImpl.setJavaMailProperties(gmailProperties());
		System.out.println(environment.getProperty("mail.host")+" "+environment.getProperty("mail.username")+" "+environment.getProperty("mail.password"));
//		Spring will pull all the values from properties file
        return  javaMailSenderImpl;
		
	}
	public Properties gmailProperties() {
		Properties properties =new Properties();
		System.out.println(environment.getProperty("mail.smtp.starttls")+" "+environment.getProperty("mail.properties.mail.smtp.starttls.enable")+" "+environment.getProperty("mail.smtp.ssl.trust"));
		properties.put(	environment.getProperty("mail.smtp.starttls"),environment.getProperty("mail.properties.mail.smtp.starttls.enable"));
		properties.put(environment.getProperty("mail.smtp.ssl.trust"),environment.getProperty("mail.host"));
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
