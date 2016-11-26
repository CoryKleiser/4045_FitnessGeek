package com.fitnessgeek.dto;

import javax.inject.Named;

@Named
public class User {

	private int userId;
	private String userName, password, firstName, lastName, email;
	private int userWeight, userHeight, // in inches
			userHeightFeet, userHeightInches;

	/**
	 * gets the user id
	 * 
	 * @return int userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * takes in an int and sets the userId equal to that int
	 * 
	 * @param int
	 *            userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * gets the username
	 * 
	 * @return String userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * takes in a String and sets the userName equal to that string
	 * 
	 * @param String
	 *            userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * gets the user's first name
	 * 
	 * @return String firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * takes in a String and sets the user's first name equal to that String
	 * 
	 * @param String
	 *            firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * gets the user's last name
	 * 
	 * @return String lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * takes in a String and sets the user's last name equal to that String
	 * 
	 * @param String
	 *            lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * gets the user's weight
	 * 
	 * @return int userWeight
	 */
	public int getUserWeight() {
		return userWeight;
	}

	/**
	 * takes in an int and sets the user's weight equal to that int
	 * 
	 * @param int
	 *            userWeight
	 */
	public void setUserWeight(int userWeight) {
		this.userWeight = userWeight;
	}

	/**
	 * gets the user's height in feet
	 * 
	 * @return int userHeightFeet
	 */
	public int getUserHeightFeet() {
		return userHeightFeet;
	}

	/**
	 * takes in an int and sets the user's height (in feet) equal to that int
	 * 
	 * @param int
	 *            userHeight
	 */
	public void setUserHeightFeet(int userHeightFeet) {
		this.userHeightFeet = userHeightFeet;
	}

	/**
	 * gets the user's height in inches
	 * 
	 * @return int userHeightInches
	 */
	public int getUserHeightInches() {
		return userHeightInches;
	}

	/**
	 * takes in an int and sets the user's height in inches equal to that int
	 * 
	 * @param int
	 *            userHeightInches
	 */
	public void setUserHeightInches(int userHeightInches) {
		this.userHeightInches = userHeightInches;
	}

	/**
	 * gets the user's password
	 * 
	 * @return String password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * takes in a String and sets the user's password equal to that String
	 * 
	 * @param String
	 *            password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * gets the user's email
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * takes in a String and sets the user's email equal to that String
	 * 
	 * @param String
	 *            email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * gets the user's height
	 * 
	 * @return int userHeight
	 */
	public int getUserHeight() {
		return userHeight;
	}

	/**
	 * takes in an int and sets the user's height equal to that int
	 * 
	 * @param int
	 *            userHeight
	 */
	public void setUserHeight(int userHeight) {
		this.userHeight = userHeight;
	}

	/**
	 * overides .toString(), returns user name
	 */

	@Override
	public String toString() {
		return userName;
	}
}