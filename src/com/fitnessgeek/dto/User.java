package com.fitnessgeek.dto;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@ManagedBean
@Scope("session")
public class User {

	private int userId;
	private String userName, password, firstName, lastName, email;
	private int userWeight, userHeight, //in inches
	userHeightFeet, userHeightInches;
	
	
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
	
	public int getUserWeight() {
		return userWeight;
	}
	public void setUserWeight(int userWeight) {
		this.userWeight = userWeight;
	}
	public int getUserHeightFeet() {
		return userHeightFeet;
	}
	public void setUserHeightFeet(int userHeightFeet) {
		this.userHeightFeet = userHeightFeet;
	}
	public int getUserHeightInches() {
		return userHeightInches;
	}
	public void setUserHeightInches(int userHeightInches) {
		this.userHeightInches = userHeightInches;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserHeight() {
		return userHeight;
	}
	public void setUserHeight(int userHeight) {
		this.userHeight = userHeight;
	}
}