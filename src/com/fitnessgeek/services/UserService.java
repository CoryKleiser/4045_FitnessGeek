package com.fitnessgeek.services;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import com.fitnessgeek.dao.IActivityDAO;
import com.fitnessgeek.dao.IFileDAO;
import com.fitnessgeek.dao.IPhotoDAO;
import com.fitnessgeek.dao.IUserDAO;
import com.fitnessgeek.dto.Activity;
import com.fitnessgeek.dto.Photo;
import com.fitnessgeek.dto.User;

@Named
public class UserService implements IUserService {

	@Inject
	private IUserDAO userDAO;

	@Inject
	private IActivityDAO activityDAO;

	@Inject
	private IFileDAO fileDAO;

	@Inject
	private IPhotoDAO photoDAO;

	@Inject
	private JMSBean jmsBean;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fitnessgeek.services.IUserService#add(com.fitnessgeek.dto.User)
	 */
	@Override
	public void add(User user) {
		getUserDAO().insert(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fitnessgeek.services.IUserService#showAllUsers()
	 */
	@Override
	public Set<User> showAllUsers() {
		return getUserDAO().fetchAllUsers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fitnessgeek.services.IUserService#showAllUsers()
	 */
	@Override
	public void add(Activity activity) {
		getActivityDAO().insert(activity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fitnessgeek.services.IUserService#showAllUsers()
	 */
	@Override
	public void update(Activity activity) {
		getActivityDAO().update(activity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fitnessgeek.services.IUserService#showAllUsers()
	 */
	@Override
	public void delete(Activity activity) {
		getActivityDAO().delete(activity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fitnessgeek.services.IUserService#showAllUsers()
	 */
	@Override
	public List<Activity> showAllActivities() {
		return getActivityDAO().fetchAllActivities();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fitnessgeek.services.IUserService#showAllUsers()
	 */
	@Override
	public void savePhoto(Photo photo, InputStream inputstream) throws Exception {
		File directory = new File(
				"/Users/Willie/DevelopmentMall/JavaWarehouse/Eclipse/EnterpriseAppDev/4045_FitnessGeek/WebContent/resources/images");
		String uniqueImageName = getUniqueImageName();
		File file = new File(directory, uniqueImageName);
		fileDAO.save(inputstream, file);

		photo.setUri(file.toString());

		photo.setUri(uniqueImageName);
		photoDAO.insert(photo);
		jmsBean.submit(photo.getUri());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fitnessgeek.services.IUserService#showAllUsers()
	 */
	@Override
	public List<Photo> fetchPhotos() {
		return photoDAO.fetchPhotos();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fitnessgeek.services.IUserService#showAllUsers()
	 */
	@Override
	public List<User> getFilteredUsers(String query) {
		return userDAO.getFilteredUsers(query);
	}

	/*
	 * Generate a unique image name
	 */
	private String getUniqueImageName() {
		String imagePrefix = "fitnessGeek";
		String imageSuffix = ".jpg";
		String middle = "";

		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		middle = sdf.format(new Date());

		return imagePrefix + middle + imageSuffix;
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
