package com.lovecalculator.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.lovecalculator.serviceinterfaces.MailSenderService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailSenderServiceImpl implements MailSenderService {
	@Autowired
	private JavaMailSenderImpl javaMailSenderImpl;

	@Override
	public String sendMail(String userName, String crushName, String toEmail, String result) {

		MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

			String htmlMsg = "<html>" + "<body>" + "<div style='text-align: center; margin-top: 20px;'>"
					+ "<p><img src='cid:loveCalculatorImage' alt='Love Calculator' style='width:200px; height:200px;'></p>"
					+ "</div>" + "<h1 style='text-align: center;'>Hello " + userName + "</h1>"
					+ "<p style='text-align: center;'>This is the result of your love calculation with " + crushName
					+ ":</p>" + "<h2 style='text-align: center;'>" + result + "</h2>"
					+ "<p style='text-align: center;'>Best regards,<br/>Love Calculator Team</p>" + "</body>"
					+ "</html>";
				
			helper.setTo(toEmail);
			helper.setSubject("Love Calculation Result");
			helper.setText(htmlMsg, true);

			// Add inline image
			if(result.equalsIgnoreCase(Relations.L_Meaning_value)) {
				helper.addInline("loveCalculatorImage", new ClassPathResource("Static/images/loveCalculator.png"));
			}
			else if(result.equalsIgnoreCase(Relations.F_Meaning_value)) {
				helper.addInline("loveCalculatorImage", new ClassPathResource("Static/images/friends.png"));
			}
			else if(result.equalsIgnoreCase(Relations.E_Meaning_value)) {
				helper.addInline("loveCalculatorImage", new ClassPathResource("Static/images/enemy.png"));
			}
			else if(result.equalsIgnoreCase(Relations.M_Meaning_value)) {
				helper.addInline("loveCalculatorImage", new ClassPathResource("Static/images/Marriage.webp"));
			}
			else if(result.equalsIgnoreCase(Relations.A_Meaning_value)) {
				helper.addInline("loveCalculatorImage", new ClassPathResource("Static/images/Affection.png"));
			}
			else if(result.equalsIgnoreCase(Relations.S_Meaning_value)) {
				helper.addInline("loveCalculatorImage", new ClassPathResource("Static/images/Sister.png"));
			}
			else {
				helper.addInline("loveCalculatorImage", new ClassPathResource("Static/images/relation.png"));
			}

			javaMailSenderImpl.send(mimeMessage);
			System.out.println("Email sent successfully");

			
		}
		catch (MessagingException e) {
			e.printStackTrace();
			return "emailFailed";
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return "emailFailed";
		}

		return "emailSuccess";
	}

}
