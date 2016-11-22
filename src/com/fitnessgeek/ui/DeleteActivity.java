package com.fitnessgeek.ui;

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

/**
 * UI Bean to handle activity deletion
 * @author moku
 *
 */
@Named
@ManagedBean
@Scope("request")
public class DeleteActivity {
	final static Logger logger = Logger.getLogger(AddUser.class);
	@Inject
	private IUserService userService;
	
	private Activity activity;
	
	public String execute(){
		//TODO:: Form Validation
		logger.info("INFO:: Entering the delete activity execute method");
		String returnMessage;
		FacesMessage fm;
				
		// get faces context
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		if(activity != null){
		//:: implement add method from StockListService
		try{
			userService.delete(activity);
			logger.info("INFO:: Activity deleted.");
			returnMessage = "success";
			// what is the message that we want to show?
			fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Activity Deleted");
			// display the message
			currentInstance.addMessage(null, fm);
		} 
		catch(Exception e) {
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
		//TODO:: navigate to home page on success/handle errors on fail
		return returnMessage;
	}
	public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Activity Selected", ((Activity) event.getObject()).toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        activity = ((Activity) event.getObject());
    }
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
}
