package com.fitnessgeek.dao;

import java.util.Set;

import com.fitnessgeek.dto.Activity;

public interface IActivityDAO {

	void insert(Activity activity);

	Set<Activity> fetchAllActivities();

}
