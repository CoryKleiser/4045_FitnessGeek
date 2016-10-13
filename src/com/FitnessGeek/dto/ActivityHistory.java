package com.FitnessGeek.dto;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@ManagedBean
@Scope("session")
public class ActivityHistory {
	
	private String activityType;
	private int activityId;
	private int activityFrequency;
	private List<Activity> activityCount;
	
	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	
	public int getActivityFrequency() {
		return activityFrequency;
	}
	public void setActivityFrequency(int activityFrequency) {
		this.activityFrequency = activityFrequency;
	}
	
	public List<Activity> getActivityCount() {
		return activityCount;
	}
	public void setActivityCount(List<Activity> activityCount) {
		this.activityCount = activityCount;
	}

}
