package com.alex.hotel;

public class Guest {
	
	private String userName; 
	private String passWord; 
	private String firstName; 
	private String lastName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	} 
	
	public Guest()
	{
		super(); 
	}
	
	public Guest(String userName, String passWord, String firstName, String lastName)
	{
		super(); 
		this.userName = userName; 
		this.passWord = passWord; 
		this.firstName = firstName; 
		this.lastName = lastName; 
	}
	
	public Guest(String uId) {
		this.userName = uId;
	}

	@Override
	public String toString()
	{
		return ""+"  User Name: " + userName + " | " +" | First Name : " + firstName +"|"+"| LastName: " + lastName + "";
	}
	
}
