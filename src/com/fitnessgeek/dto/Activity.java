package com.fitnessgeek.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
public class Activity {

	private int Id;
	private String typeName;
	private String dateCompleted;
	private int totalTrackingAmount;
	private Date formatedDateCompleted;

	public String getDateCompleted() {

		return dateCompleted;
	}

	public void setDateCompleted(String dateCompleted) {
		this.dateCompleted = dateCompleted;
		formatDate();
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

	public Date getFormatedDateCompleted() {
		return formatedDateCompleted;
	}

	public void setFormatedDateCompleted(Date formatedDateCompleted) {
		this.formatedDateCompleted = formatedDateCompleted;
		formatDateString();
	}

	private void formatDate() {
		try {
			this.formatedDateCompleted = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy").parse(dateCompleted);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void formatDateString() {
		this.dateCompleted = formatedDateCompleted.toString();
	}

}
