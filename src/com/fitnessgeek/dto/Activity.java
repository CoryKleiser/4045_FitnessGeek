package com.fitnessgeek.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

/**
 * Our Activity class This contains the approperiate methods to implement
 * Activity
 */
@Named
public class Activity {

	private int Id;
	private String typeName;
	private String dateCompleted;
	private int totalTrackingAmount;
	private Date formatedDateCompleted;

	/**
	 * gets the date completed
	 * 
	 * @return Date datecompleted
	 */
	public String getDateCompleted() {

		return dateCompleted;
	}

	/**
	 * takes in a date, and sets the dateCompleted equal to that date
	 * 
	 * @param Date
	 *            dateCompleted
	 */
	public void setDateCompleted(String dateCompleted) {
		this.dateCompleted = dateCompleted;
		formatDate();
	}

	/**
	 * gets the total tracking ammount
	 * 
	 * @return String totalTrackingAmount
	 */
	public int getTotalTrackingAmount() {
		return totalTrackingAmount;
	}

	/**
	 * takes in a String and sets the total tracking amount equal to that string
	 * 
	 * @param String
	 *            totalTrackingAmount
	 */
	public void setTotalTrackingAmount(int totalTrackingAmount) {
		this.totalTrackingAmount = totalTrackingAmount;
	}

	/**
	 * gets the type name
	 * 
	 * @return String typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * takes in a String and sets the typeName equal to that string
	 * 
	 * @param String
	 *            typeName
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * gets the user id
	 * 
	 * @return int userId
	 */
	public int getId() {
		return Id;
	}

	/**
	 * takes in an int and sets the userId equal to that int
	 * 
	 * @param int
	 *            userId
	 */
	public void setId(int id) {
		Id = id;
	}

	/**
	 * This gest the date, in date format
	 */
	public Date getFormatedDateCompleted() {
		return formatedDateCompleted;
	}

	/**
	 * This sets the date in date format
	 */
	public void setFormatedDateCompleted(Date formatedDateCompleted) {
		this.formatedDateCompleted = formatedDateCompleted;
		formatDateString();
	}

	/**
	 * This will change the a date string to Date
	 */
	private void formatDate() {
		try {
			this.formatedDateCompleted = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy").parse(dateCompleted);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This will change Date into a string
	 */
	private void formatDateString() {
		this.dateCompleted = formatedDateCompleted.toString();
	}

}
