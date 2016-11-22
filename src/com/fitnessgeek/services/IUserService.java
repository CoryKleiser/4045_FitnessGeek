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

	void add(Activity activity);

	List<Activity> showAllActivities();

	String stringifyDate(Date date);

}