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
	public List<Activity> showAllActivities(){
		return getActivityDAO().fetchAllActivities();
	}
	@Override
	public String stringifyDate(Date date){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.format(date);
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
