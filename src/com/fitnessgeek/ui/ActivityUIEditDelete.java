package com.fitnessgeek.ui;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;

import com.fitnessgeek.dto.Activity;
import com.fitnessgeek.services.IUserService;
@Named
@ManagedBean
@Scope("session")
public class ActivityUIEditDelete {
	
	
	private Activity activity;

	@Inject
	private IUserService userService;


	final static Logger logger = Logger.getLogger(ActivityUI.class);

	public String executeEdit() {
		logger.info("INFO:: Entering the edit activity execute method");
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Edit", "Item Updated");
		currentInstance.addMessage(null, fm);

		userService.update(getActivity());
		
		return "Edit";
	}

	public String executeDelete() {
		// TODO:: Form Validation
		logger.info("INFO:: Entering the delete activity execute method");
		String returnMessage;
		FacesMessage fm;

		// get faces context
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		if (getActivity() != null) {
			// :: implement add method from StockListService
			try {
				userService.delete(getActivity());
				logger.info("INFO:: Activity deleted.");
				returnMessage = "success";
				// what is the message that we want to show?
				fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Activity Deleted");
				// display the message
				currentInstance.addMessage(null, fm);
				FacesContext.getCurrentInstance().getExternalContext().redirect("activities.xhtml");
			} catch (Exception e) {
				returnMessage = "fail";
				logger.error("ERROR:: Activity was not Deleted.");
				logger.error(e);
				e.printStackTrace();
				fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Whoops!", "Activity was not deleted.");
				currentInstance.addMessage(null, fm);
			}
		} else {
			fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uh Oh", "Select an activity");
			currentInstance.addMessage(null, fm);
			returnMessage = "nullentry";
		}
		// TODO:: navigate to home page on success/handle errors on fail
		return returnMessage;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
}
