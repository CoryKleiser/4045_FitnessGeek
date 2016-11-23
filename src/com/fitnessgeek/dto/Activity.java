package com.fitnessgeek.dto;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;


/**
 * Our Activity class
 * This contains the approperiate methods to implement Activity
 */
@Named
@ManagedBean
@Scope("session")
public class Activity {
	
	private String typeName;
	private int userId;
	private Date dateCompleted;
	private String completionDate;
	private String totalTrackingAmount;
	
	/**
	 * gets the date completed
	 * @return Date datecompleted
	 */
	public Date getDateCompleted() {
		return dateCompleted;
	}
	
	/**
	 * takes in a date, and sets the dateCompleted equal to that date
	 * @param Date dateCompleted
	 */
	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}
	
	/**
	 * gets the total tracking ammount
	 * @return String totalTrackingAmount
	 */
	public String getTotalTrackingAmount() {
		return totalTrackingAmount;
	}
	
	/**
	 * takes in a String and sets the total tracking amount equal to that string
	 * @param String totalTrackingAmount
	 */
	public void setTotalTrackingAmount(String totalTrackingAmount) {
		this.totalTrackingAmount = totalTrackingAmount;
	}
	
	/**
	 * gets the type name
	 * @return String typeName
	 */
	public String getTypeName() {
		return typeName;
	}
	
	/**
	 * takes in a String and sets the typeName equal to that string
	 * @param String typeName
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	/**
	 * gets the user id
	 * @return int userId
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * takes in an int and sets the userId equal to that int
	 * @param int userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	 * gets the completion date
	 * @return String completionDate
	 */
	public String getCompletionDate() {
		return completionDate;
	}
	
	/**
	 * takes in a String and sets the completionDate equal to that String
	 * @param String completionDate
	 */
	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}
}
