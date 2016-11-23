package com.fitnessgeek.ui;

import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;

import com.fitnessgeek.dto.User;
import com.fitnessgeek.services.IUserService;

@Named
@ManagedBean
@Scope("session")
/**
 * test class for time being
 * 
 * @author moku
 *
 */
public class UserUI {
	final static Logger logger = Logger.getLogger(UserUI.class);

	@Inject
	private IUserService userService;

	@Inject
	private User user;

	private Set<User> users;

	public Set<User> getUsers() {
		users = userService.showAllUsers();
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String execute() {
		// TODO:: Form Validation
		logger.info("INFO:: Entering the add user execute method");
		String returnMessage;
		FacesMessage fm;

		// get faces context
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		if (user != null && user.getUserName().length() > 3 && user.getPassword().length() > 4) {
			// :: implement add method from StockListService
			try {
				/*
				 * Get the user height and then convert it to Inches.
				 */
				user.setUserHeight(user.getUserHeightFeet() * 12 + user.getUserHeightInches());
				userService.add(user);
				logger.info("INFO:: User saved successfully");
				returnMessage = "success";
				// what is the message that we want to show?
				fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved", "User Saved");
				// display the message
				currentInstance.addMessage(null, fm);
			} catch (Exception e) {
				returnMessage = "fail";
				logger.error("ERROR:: User did not save successfully.");
				logger.error(e);
				fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Whoops!",
						"Something went wrong. Please try again later.");
				currentInstance.addMessage(null, fm);
			}
		} else {
			fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uh Oh", "Looks like you missed something");
			currentInstance.addMessage(null, fm);
			returnMessage = "nullentry";
		}
		// TODO:: navigate to home page on success/handle errors on fail
		return returnMessage;
	}

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
