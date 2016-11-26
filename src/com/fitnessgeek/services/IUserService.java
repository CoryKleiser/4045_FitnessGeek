package com.fitnessgeek.services;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

import com.fitnessgeek.dto.Activity;
import com.fitnessgeek.dto.Photo;
import com.fitnessgeek.dto.User;

public interface IUserService {

	/**
	 * add user
	 * 
	 * @param user
	 *            to add
	 */
	void add(User user);

	/**
	 * show all registered users
	 * 
	 * @return set of all users
	 */
	Set<User> showAllUsers();

	/**
	 * add Activity
	 * 
	 * @param activity
	 */
	void add(Activity activity);

	/**
	 * retrieve all activities
	 * 
	 * @return all activities
	 */
	List<Activity> showAllActivities();

	/**
	 * save a photo
	 * 
	 * @param activity
	 */
	void savePhoto(Photo photo, InputStream inputstream) throws Exception;

	/**
	 * get all photos
	 * 
	 * @param activity
	 */
	List<Photo> fetchPhotos();

	/**
	 * update an activity
	 * 
	 * @param activity
	 */
	void update(Activity activity);

	/**
	 * delete an activity
	 * 
	 * @param activity
	 */
	void delete(Activity activity);

	/**
	 * Get filtered list of users
	 */
	List<User> getFilteredUsers(String query);
}