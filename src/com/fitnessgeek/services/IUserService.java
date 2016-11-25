package com.fitnessgeek.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fitnessgeek.dto.Activity;
import com.fitnessgeek.dto.User;

public interface IUserService {

	/**
	 * add user
	 * @param user to add
	 */
	void add(User user);

	/**
	 * show all registered users
	 * @return set of all users
	 */
	Set<User> showAllUsers();
	
	/**
	 * add Activity
	 * @param activity
	 */
	void add(Activity activity);
	
	/**
	 * retrieve all activities
	 * @return all activities
	 */
	List<Activity> showAllActivities();
	
	/**
	 * turn Date into formatted String
	 * @param date
	 * @return formatted String
	 */
	String stringifyDate(Date date);
	
	/**
	 * delete an activity
	 * @param activity
	 */
	void delete(Activity activity);

}
