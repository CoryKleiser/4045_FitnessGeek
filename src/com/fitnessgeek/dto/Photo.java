package com.fitnessgeek.dto;

import java.util.Date;

import javax.inject.Named;

/**
 * Our Photo class This contains the appropriate methods to implement Photos
 */
@Named
public class Photo {
	private int id;
	private String uri;
	private Date dateTaken;
	private String contributor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Date getDateTaken() {
		return dateTaken;
	}

	public void setDateTaken(Date dateTaken) {
		this.dateTaken = dateTaken;
	}

	public String getContributor() {
		return contributor;
	}

	public void setContributor(String contributor) {
		this.contributor = contributor;
	}

	@Override
	public String toString() {
		return uri;
	}
}
