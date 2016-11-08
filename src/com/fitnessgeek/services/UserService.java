package com.fitnessgeek.services;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import com.fitnessgeek.dao.IActivityDAO;
import com.fitnessgeek.dao.IUserDAO;
import com.fitnessgeek.dto.Activity;
import com.fitnessgeek.dto.User;

@Named
public class UserService implements IUserService {

	@Inject
	private
	IUserDAO userDAO;
	
	@Inject
	private
	IActivityDAO activityDAO;
		
	/* (non-Javadoc)
	 * @see com.fitnessgeek.services.IUserService#add(com.fitnessgeek.dto.User)
	 */
	@Override
	public void add(User user) {
		getUserDAO().insert(user);
	}
	/* (non-Javadoc)
	 * @see com.fitnessgeek.services.IUserService#showAllUsers()
	 */
	@Override
	public Set<User> showAllUsers(){
		return getUserDAO().fetchAllUsers();
	}
	@Override
	public void add(Activity activity) {
		getActivityDAO().insert(activity);
	}
	@Override
	public Set<Activity> showAllActivities(){
		return getActivityDAO().fetchAllActivities();
	}
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public IActivityDAO getActivityDAO() {
		return activityDAO;
	}
	public void setActivityDAO(IActivityDAO activityDAO) {
		this.activityDAO = activityDAO;
	}
}
