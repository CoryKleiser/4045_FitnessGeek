package com.fitnessgeek.ui;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;

import com.fitnessgeek.dto.Activity;
import com.fitnessgeek.dto.User;
import com.fitnessgeek.services.IUserService;

@Named
@ManagedBean
@Scope("session")
public class AddActivity {
final static Logger logger = Logger.getLogger(AddUser.class);
	
	@Inject
	private User user;
	
	@Inject
	private Activity activity;
	
	@Inject
	private IUserService userService;
	
	/**
	 * handle user registration submission 
	 * @return return message success/fail
	 */
	public String execute(){
		
		logger.info("INFO:: Entering the add activity execute method");
		String returnMessage;
		FacesMessage fm;
		
		// get faces context
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		if(activity != null){
		try{
			activity.setCompletionDate(userService.stringifyDate(activity.getDateCompleted()));
			userService.add(activity);
			logger.info("INFO:: User Activity saved successfully");
			returnMessage = "success";
			// what is the message that we want to show?
			fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved", "Activity Saved");
			// display the message
			currentInstance.addMessage(null, fm);
		} 
		catch(Exception e) {
			returnMessage = "fail";
			logger.error("ERROR:: User Activity did not save successfully.");
			logger.error(e);
			e.printStackTrace();
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
	 * Takes in a User and sets the current User to that value
	 * @param User user
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
