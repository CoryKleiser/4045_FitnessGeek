package com.fitnessgeek.ui;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.fitnessgeek.dto.User;

@Named
@ManagedBean
@Scope("session")
public class loginUser {

	public User user;

	/**
	 * Gets the user
	 * @return User
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * This method takes in a User and sets the current user equal to that value
	 * @param User user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * This method attemps to log a user in given a username and a password
	 * @param String username, String password
	 * @return String
	 */
	public String execute(String username, String password) {
		return "success";
	}
	
	/**
	 * This method is called when a user tries to register
	 * @return String
	 */
	public String register() {
		return "success";
	}
	
	/**
	 * This method is called when a user tries to login via Facebook authentication
	 * @return String
	 */
	public String facebookLogin() {
		return "success";
	}
	
	/**
	 * This method is called when a user tries to login via Google authentication
	 * @return String
	 */
	public String googleLogin() {
		return "success";
	}
	
}
