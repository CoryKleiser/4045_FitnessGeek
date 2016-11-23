package com.fitnessgeek.dao;

import java.util.List;

import com.fitnessgeek.dto.Activity;

public interface IActivityDAO {

	void insert(Activity activity);

	List<Activity> fetchAllActivities();
	
	void delete(Activity activity);
	
	void update(Activity activity);

}
