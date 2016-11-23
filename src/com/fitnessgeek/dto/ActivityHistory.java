package com.fitnessgeek.dto;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

/**
 * Our ActivityHistory class
 * This contains the approperiate methods to implement Activity History
 */
@Named
@ManagedBean
@Scope("session")
public class ActivityHistory {
	
	private String activityType;
	private int activityId;
	private int activityFrequency;
	private List<Activity> activityCount;
	
	/**
	 * gets the activity type
	 * @return String activityType
	 */
	public String getActivityType() {
		return activityType;
	}
	
	/**
	 * takes in a String and sets the activity type to that string
	 * @param String activityType
	 */
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	
	/**
	 * gets the activity id
	 * @return int activityId
	 */
	public int getActivityId() {
		return activityId;
	}
	
	/**
	 * takes in an int and sets the activityId to that int
	 * @param int activityId
	 */
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	
	/**
	 * gets the activity frequency
	 * @return int activityFrequency
	 */
	public int getActivityFrequency() {
		return activityFrequency;
	}
	
	/**
	 * takes in an int and sets the activity frequency to that int
	 * @param int activityFrequency
	 */
	public void setActivityFrequency(int activityFrequency) {
		this.activityFrequency = activityFrequency;
	}
	
	/**
	 * gets the activity count
	 * @return List<Activity> activityCount
	 */
	public List<Activity> getActivityCount() {
		return activityCount;
	}
	
	/**
	 * takes in a List<Avtivity> and sets the activityCount equal to that List<Activity>
	 * @param List<Avtivity> activityCount
	 */
	public void setActivityCount(List<Activity> activityCount) {
		this.activityCount = activityCount;
	}

}
