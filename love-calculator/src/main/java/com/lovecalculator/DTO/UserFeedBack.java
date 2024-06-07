package com.lovecalculator.DTO;

import com.lovecalculator.validation.Email;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserFeedBack {
	
	@NotBlank(message = "Your Name Should Not Be Left Blank")
	@Size(min = 3, max = 30, message = "Your Name must contains min 3 and max 30 charaters")
	private String userName;
	@Email
	private String userEmail;
	@NotBlank
	@NotBlank(message = "Feedback Should Not Be Left Blank")
	@Size(min = 3, message = "Feedback  must contains min 3 charaters")
	private String feedbackMessage;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getFeedbackMessage() {
		return feedbackMessage;
	}

	public void setFeedbackMessage(String feedbackMessage) {
		this.feedbackMessage = feedbackMessage;
	}

	@Override
	public String toString() {
		return "UserFeedBack [userName=" + userName + ", userEmail=" + userEmail + ", feedbackMessage="
				+ feedbackMessage + "]";
	}
	
	

}
