package com.fitnessgeek.ui;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;

import com.fitnessgeek.dto.User;
import com.fitnessgeek.services.IUserService;

/**
 * Add User UI class
 * @author moku
 *
 */
@Named
@ManagedBean
@Scope("request")
public class AddUser {
final static Logger logger = Logger.getLogger(AddUser.class);
	
	@Inject
	private User user;
	
	@Inject
	private IUserService userService;
	
	/**
	 * handle user registration submission 
	 * @return return message success/fail
	 */
	public String execute(){
		
		logger.info("INFO:: Entering the add user execute method");
		String returnMessage;
		FacesMessage fm;
		
		// get faces context
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		if(user != null && user.getUserName().length() > 3 && user.getPassword().length() > 4){
		//:: implement add method from StockListService
		try{
			user.setUserHeight(user.getUserHeightFeet()*12 + user.getUserHeightInches());
			userService.add(user);
			logger.info("INFO:: User saved successfully");
			returnMessage = "success";
			// what is the message that we want to show?
			fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved", "User Saved");
			// display the message
			currentInstance.addMessage(null, fm);
		} 
		catch(Exception e) {
			returnMessage = "fail";
			logger.error("ERROR:: User did not save successfully.");
			logger.error(e);
			fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Whoops!", "Something went wrong. Please try again later.");
			currentInstance.addMessage(null, fm);
		}
		} else {
			fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uh Oh", "Looks like you missed something");
			currentInstance.addMessage(null, fm);
			returnMessage = "nullentry";
		}
		
		return returnMessage;
	}

	/**
	 * Gets the user
	 * @return User 
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Takes in a User and sets the current Use to that value
	 * @param User user
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
