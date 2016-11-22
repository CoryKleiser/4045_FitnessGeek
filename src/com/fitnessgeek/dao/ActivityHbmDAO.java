package com.fitnessgeek.dao;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Named;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fitnessgeek.dto.Activity;

@Named
public class ActivityHbmDAO implements IActivityDAO  {

	/*
	 * (non-Javadoc)
	 * @see com.fitnessgeek.dao.IActivityDAO#insert(com.fitnessgeek.dto.Activity)
	 * Add a new activity based on the users inputs, and then save it to the Database. 
	 */
	@Override
	public void insert(Activity activity) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(activity);
		
		session.getTransaction().commit();
		session.close();
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.fitnessgeek.dao.IActivityDAO#fetchAllActivities()
	 * fetch all the users activities from the DB and return them as a set of activities. 
	 */
	@Override
	public Set<Activity> fetchAllActivities() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Activity");
		
		@SuppressWarnings("unchecked")
		Set<Activity> activitySet = new HashSet<Activity>(query.list());
		
		session.getTransaction().commit();
		session.close();
		
		return activitySet;
	}
	
/*
 * (non-Javadoc)
 * @see com.fitnessgeek.dao.IActivityDAO#delete(com.fitnessgeek.dto.Activity)
 * Delete the selected activity and update the database
 */
	@Override
	public void delete(Activity activity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.delete(activity);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	/* 
	 * (non-Javadoc)
	 * @see com.fitnessgeek.dao.IActivityDAO#update(com.fitnessgeek.dto.Activity)
	 * Update the Activity data with the data the User has input in the UI and push the changes to the DB.
	 */
	@Override
	public void update(Activity activity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.update(activity);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
