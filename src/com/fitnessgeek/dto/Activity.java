package com.fitnessgeek.dto;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@ManagedBean
@Scope("session")
public class Activity {
	
	private String typeName;
	private int typeId;
	private Date dateCompleted;
	private String totalTrackingAmount;
	
	public Date getDateCompleted() {
		return dateCompleted;
	}
	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}
	
	public String getTotalTrackingAmount() {
		return totalTrackingAmount;
	}
	public void setTotalTrackingAmount(String totalTrackingAmount) {
		this.totalTrackingAmount = totalTrackingAmount;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
}
