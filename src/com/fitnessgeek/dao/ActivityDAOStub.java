package com.fitnessgeek.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.fitnessgeek.dto.Activity;

@Named
public class ActivityDAOStub implements IActivityDAO {

	public List<Activity> activities;
	
	public ActivityDAOStub() {
		activities = new ArrayList<Activity>();
	}
	
	@Override
	public void insert(Activity activity) {
		activity.setId(activities.size() + 1);
		activities.add(activity);
	}
	@Override
	public List<Activity> fetchAllActivities(){
		return activities;
	}

	@Override
	public void delete(Activity activity) {
		activities.remove(activity);
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.fitnessgeek.dao.IActivityDAO#update(com.fitnessgeek.dto.Activity)
	 * 
	 */
	@Override
	public void update(Activity activity) {
		for (Activity activityLoop : activities) {
			if(activityLoop.getId() == activity.getId()){
				activities.remove(activityLoop);
				activities.add(activity);
			}
		}
		
	}

}
