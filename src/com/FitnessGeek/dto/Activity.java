package com.FitnessGeek.dto;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@ManagedBean
@Scope("session")
public class Activity {
	
	private String activityName;
	private int activityId;
	private Date dateCompleted;
	private float totalTrackingAmount;
	private float goalAmount;
	ActivityHistory activityHistory;
	
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
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
