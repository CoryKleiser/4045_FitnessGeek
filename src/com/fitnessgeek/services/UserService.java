package com.fitnessgeek.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import com.fitnessgeek.dao.IActivityDAO;
import com.fitnessgeek.dao.IUserDAO;
import com.fitnessgeek.dto.Activity;
import com.fitnessgeek.dto.User;

/**
 * This is our UserService class. It contains the methods necessary to implement our IUserService interface
 */
@Named
public class UserService implements IUserService {

	@Inject
	private
	IUserDAO userDAO;
	
	@Inject
	private
	IActivityDAO activityDAO;
		
	/**
	 * This method takes in a new user, and inserts them into our DAO
	 * @param User user
	 * 
	 * *******************
	 * (non-Javadoc)
	 * @see com.fitnessgeek.services.IUserService#add(com.fitnessgeek.dto.User)
	 */
	@Override
	public void add(User user) {
		getUserDAO().insert(user);
	}
	
	/**
	 * This method returns a list of all users
	 * @return Set<User> 
	 * 
	 * *******************
	 * (non-Javadoc)
	 * @see com.fitnessgeek.services.IUserService#showAllUsers()
	 */
	@Override
	public Set<User> showAllUsers(){
		return getUserDAO().fetchAllUsers();
	}
	
	/**
	 * This method takes in an Activity and add sit to our DAO
	 * @param Activity activity
	 */
	@Override
	public void add(Activity activity) {
		getActivityDAO().insert(activity);
	}
	
	/**
	 * This method takes in an Activity and deletes it from our DAO
	 * @param Activity activity
	 */
	@Override
	public void delete(Activity activity){
		getActivityDAO().delete(activity);
	}
	
	/**
	 * This method returns a List of all our Activities
	 * @return List<Activity>
	 */
	@Override
	public List<Activity> showAllActivities(){
		return getActivityDAO().fetchAllActivities();
	}
	
	/**
	 * This method takes in a Date, converts it to a String, and returns that String
	 * @param Date date
	 * @return String
	 */
	@Override
	public String stringifyDate(Date date){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.format(date);
	}
	
	/**
	 * This method gets the User DAO
	 * @return IUserDao userDAO
	 */
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * This method takes in a User DAO and sets our user DAO equal to that value
	 * @param IUserDAO userDAO
	 */
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	/**
	 * This method gets the Activity DAO
	 * @return IActivityDAO activity DAO
	 */
	public IActivityDAO getActivityDAO() {
		return activityDAO;
	}
	
	/**
	 * This method takes in an IActivityDAO and sets our activityDAO equal to that value
	 * @param IActivityDAO activityDAO
	 */
	public void setActivityDAO(IActivityDAO activityDAO) {
		this.activityDAO = activityDAO;
	}
}
