package com.lovecalculator.DTO;

public class SignUpInfoDTO {
	
	private String name;
	
	private String userName;
	private String password;
	private String cPassword;
	private String country="India";
	private String hobby;
	private String gender="Male";
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
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "LoginInfoDTO [name=" + name + ", userName=" + userName + ", password=" + password + ", cPassword="
				+ cPassword + ", country=" + country + ", hobby=" + hobby + ", gender=" + gender + "]";
	}
	

}
