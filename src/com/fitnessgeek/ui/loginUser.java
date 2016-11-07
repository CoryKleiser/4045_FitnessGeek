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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String execute(String username, String password) {
		return "success";
	}
	
	public String register() {
		return "success";
	}
	
	public String facebookLogin() {
		return "success";
	}
	
	public String googleLogin() {
		return "success";
	}
	
}
