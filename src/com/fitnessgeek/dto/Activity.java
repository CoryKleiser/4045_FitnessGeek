package com.fitnessgeek.dto;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@ManagedBean
@Scope("session")
public class Activity {
	
	private int Id;
	private String typeName;
	private String dateCompleted;
	private int totalTrackingAmount;
	
	public String getDateCompleted() {
		return dateCompleted;
	}
	public void setDateCompleted(String dateCompleted) {
		this.dateCompleted = dateCompleted;
	}
	
	public int getTotalTrackingAmount() {
		return totalTrackingAmount;
	}
	public void setTotalTrackingAmount(int totalTrackingAmount) {
		this.totalTrackingAmount = totalTrackingAmount;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
}
