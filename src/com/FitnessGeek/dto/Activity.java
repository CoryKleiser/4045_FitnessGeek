package com.FitnessGeek.dto;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@ManagedBean
@Scope("session")
public class Activity {
	
	private String activityTypeName;
	private int activityTypeId;
	private Date dateCompleted;
	private float totalTrackingAmount;
	private float goalAmount;
	ActivityHistory activityHistory;
	
	public String getActivityTypeName() {
		return activityTypeName;
	}
	public void setActivityTypeName(String activityTypeName) {
		this.activityTypeName = activityTypeName;
	}
	
	public int getActivityTypeId() {
		return activityTypeId;
	}
	public void setActivityTypeId(int activityTypeId) {
		this.activityTypeId = activityTypeId;
	}
	
	public Date getDateCompleted() {
		return dateCompleted;
	}
	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}
	
	public float getTotalTrackingAmount() {
		return totalTrackingAmount;
	}
	public void setTotalTrackingAmount(float totalTrackingAmount) {
		this.totalTrackingAmount = totalTrackingAmount;
	}
	
	public float getGoalAmount() {
		return goalAmount;
	}
	public void setGoalAmount(float goalAmount) {
		this.goalAmount = goalAmount;
	}
	
	
}
