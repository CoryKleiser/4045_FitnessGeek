package com.FitnessGeek.dto;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@ManagedBean
@Scope("session")
public class User {

	private int userId;
	private String userName, userPassword, firstName, lastName;
	private int userWeight, userHeight;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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
	
	public int getUserHeight() {
		return userHeight;
	}
	public void setUserHeight(int userHeight) {
		this.userHeight = userHeight;
	}
	
	public int getUserWeight() {
		return userWeight;
	}
	public void setUserWeight(int userWeight) {
		this.userWeight = userWeight;
	}
	
}