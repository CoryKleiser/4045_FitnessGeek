package com.fitnessgeek.ui;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.fitnessgeek.dto.Activity;
import com.fitnessgeek.services.IUserService;

@Named
@ManagedBean
@Scope("session")

/**
 * test class for time being
 * @author moku
 */
public class GetActivities {

	@Inject
	private IUserService userService;

	private List<Activity> activities;

	/**
	 * This method returns a List of all our Activities
	 * @return List<Activity>
	 */
	public List<Activity> getActivities() {
		activities = userService.showAllActivities();
		return activities;
	}

	/**
	 * This method takes in a List of Activities and sets our Activity List equal to that value
	 * @param List<Activity> activities
	 */
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	
}
