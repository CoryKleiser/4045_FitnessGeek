package com.fitnessgeek.dao;

import java.util.List;

import com.fitnessgeek.dto.Activity;

public interface IActivityDAO {
	/**
	 * insert activity into database
	 * @param activity
	 */
	void insert(Activity activity);
	/**
	 * fetch all user activities from database
	 * @return all activities
	 */
	List<Activity> fetchAllActivities();
	/**
	 * delete activity from database
	 * @param activity
	 */
	void delete(Activity activity);

}
