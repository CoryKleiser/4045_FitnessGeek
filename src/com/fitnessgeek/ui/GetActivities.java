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
 *
 */
public class GetActivities {

	@Inject
	private IUserService userService;

	private List<Activity> activities;


	public List<Activity> getActivities() {
		activities = userService.showAllActivities();
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	
}
