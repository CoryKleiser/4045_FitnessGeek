package com.fitnessgeek.ui;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;

import com.fitnessgeek.dto.Activity;
import com.fitnessgeek.services.IUserService;

@Named
@ManagedBean
@Scope("request")
public class ActivityUI {

	@Inject
	private Activity activity;

	@Inject
	private IUserService userService;
	
	@Inject
	ActivityUIEditDelete activityUIEditDelete;

	private List<Activity> activities;

	final static Logger logger = Logger.getLogger(ActivityUI.class);

	public String executeAdd() {
		// TODO:: Form Validation
		// TODO:: associate user with userId
		logger.info("INFO:: Entering the add activity execute method");
		String returnMessage;
		FacesMessage fm;

		// get faces context
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		if (activity != null) {
			try {
				userService.add(activity);
				logger.info("INFO:: User Activity saved successfully");
				returnMessage = "success";
				// what is the message that we want to show?
				fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved", "Activity Saved");
				// display the message
				currentInstance.addMessage(null, fm);
			} catch (Exception e) {
				returnMessage = "fail";
				logger.error("ERROR:: User Activity did not save successfully.");
				logger.error(e);
				e.printStackTrace();
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

	public void onRowSelect(SelectEvent event) {

		Activity activitySelected = ((Activity) event.getObject());
		
		activityUIEditDelete.setActivity(activitySelected);
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("activityEdit.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Activity> getActivities() {
		activities = userService.showAllActivities();
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

}
