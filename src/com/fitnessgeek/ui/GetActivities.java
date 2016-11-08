package com.fitnessgeek.ui;

import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.fitnessgeek.dto.Activity;
import com.fitnessgeek.services.IUserService;

@Named
@ManagedBean
@Scope("request")
/**
 * test class for time being
 * @author moku
 *
 */
public class GetActivities {

	@Inject
	private IUserService userService;
	
	private Set<Activity> activities;


	public Set<Activity> getActivities() {
		activities = userService.showAllActivities();
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}
	
}
