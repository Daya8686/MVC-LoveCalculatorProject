package com.lovecalculator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.lovecalculator.serviceinterfaces.FeedbackService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackServiceImpl.class);
	
	@Autowired
	private JavaMailSenderImpl javaMailSenderImpl;

	@Override
	public  String feedProccess(String userName, String userEmail, String feedbackMessage) {
		LOGGER.info("Process is inside FeedbackServiceImpl");
		LOGGER.info("Process inside feedProccess Method");
		MimeMessage mimeMessageForUser = javaMailSenderImpl.createMimeMessage();
		if(mimeMessageForUser==null) {
			LOGGER.info("MimeMessageForUser object is null");
		}
		MimeMessage mimeMessageForDev=javaMailSenderImpl.createMimeMessage();
		if(mimeMessageForDev==null) {
			LOGGER.info("mimeMessageForDev object is null");
		}
		String pageResponce="submitedFeedback";
		LOGGER.info("Page initial responce is "+pageResponce);
		
		try {
			LOGGER.info("Inside try block of feedProccess method");
			MimeMessageHelper mailForUser =new MimeMessageHelper(mimeMessageForUser, true, "UTF-8"); 
				String textToUser="<html>" + "<body>" + "<div style='text-align: center; margin-top: 20px;'>"
//						+ "<p><img src='cid:loveCalculatorImage' alt='Love Calculator' style='width:200px; height:200px;'></p>"
						+ "</div>" + "<h1 style='text-align: center;'>Hello " + userName + "</h1>"
						+ "<p style='text-align: center;'>Thank you for sending feedback to us"
						+ ":</p>" + "<p style='text-align: center;'> We definately look into it 📧 "+"</p>"
						+ "<p style='text-align: center;'>Best regards,<br/>Love Calculator Team</p>" + "</body>"
						+ "</html>";
				mailForUser.setTo(userEmail);
				mailForUser.setSubject("THANK YOU FOR YOUR FEEDBACK");
				mailForUser.setText(textToUser,true);
				javaMailSenderImpl.send(mimeMessageForUser);
				LOGGER.info("Mail is sent to "+userEmail);
				
				MimeMessageHelper feedbackMail =new MimeMessageHelper(mimeMessageForDev, true, "UTF-8"); 
				String feedbackText="<html>" + "<body>" + "<div style='text-align: center; margin-top: 20px;'>"
//						+ "<p><img src='cid:loveCalculatorImage' alt='Love Calculator' style='width:200px; height:200px;'></p>"
						+ "</div>" + "<h2 style='text-align: center;'>Hello Love Calculator Developer"  + "</h2>"
						+ "<p style='text-align: center;'>User "+userName+", Suggest that "
						+ ":</p><br>" + "<p style='text-align: center;'>["+feedbackMessage+"]</p>"
						+ "<p style='text-align: center;'>User Email is: "+userEmail+" </p>"
						+ "<br><br><p style='text-align: center;'>Best regards,<br/>Love Calculator Team</p>" + "</body>"
						+ "</html>";
				feedbackMail.setTo(javaMailSenderImpl.getUsername());
				feedbackMail.setSubject("Feedback from "+userName);
				feedbackMail.setText(feedbackText,true);
				javaMailSenderImpl.send(mimeMessageForDev);
				LOGGER.info("Feedback is sent from user("+userName+"-"+userEmail+") to developer email"+javaMailSenderImpl.getUsername());
			
		}
		catch(MessagingException e) {
			e.printStackTrace();
			LOGGER.info("Exception inside FeedbackServiceImpl.feedProcess method. Inside Catch block of MessageException");
			pageResponce="feedbackMailFailed";
		}
		catch(Exception e) {
			e.printStackTrace();
			LOGGER.info("Exception inside FeedbackServiceImpl.feedProcess method. Inside Catch block of Exception");
			pageResponce="feedbackMailFailed";
		}
		
		LOGGER.info("No Exception inside FeedbackServiceImpl.feedProcess method");
		return pageResponce;
	}

}
