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
	 * @param user to add
	 */
	void add(User user);

	/**
	 * show all registered users
	 * @return set of all users
	 */
	Set<User> showAllUsers();

	void add(Activity activity);

	Set<Activity> showAllActivities();

	void savePhoto(Photo photo, InputStream inputstream) throws Exception;

	List<Photo> fetchPhotos();

}