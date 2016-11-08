package com.fitnessgeek.dao;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Named;

import com.fitnessgeek.dto.Activity;

@Named
public class ActivityDAO implements IActivityDAO {

	public Set<Activity> activities;
	
	public ActivityDAO() {
		activities = new HashSet<Activity>();
	}
	
	@Override
	public void insert(Activity activity) {
		// TODO Implement Hibernate
		activities.add(activity);
	}
	@Override
	public Set<Activity> fetchAllActivities(){
		return activities;
	}

}
