package com.lovecalculator.DTO;

import java.util.Arrays;

import com.lovecalculator.validation.Age;

import jakarta.validation.Valid;

public class SignUpInfoDTO {
	
	private String name;
	
	private String userName;
	private String password;
	private String cPassword;
	private String country="India";
	private String[] hobby;
	private String gender="Male";
	
	@Age(lower = 30, upper = 90, message = "The age must be in between {lower} to {upper}")
	private Integer age;
	
//	@Valid
	private CommunicationDetails communicationDetails;
	
	public CommunicationDetails getCommunicationDetails() {
		return communicationDetails;
	}
	public void setCommunicationDetails(CommunicationDetails communicationDetails) {
		this.communicationDetails = communicationDetails;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getcPassword() {
		return cPassword;
	}
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "SignUpInfoDTO [name=" + name + ", userName=" + userName + ", password=" + password + ", cPassword="
				+ cPassword + ", country=" + country + ", hobby=" + Arrays.toString(hobby) + ", gender=" + gender
				+ ", age=" + age + ", communicationDetails=" + communicationDetails + "]";
	}
	
	
	

}
