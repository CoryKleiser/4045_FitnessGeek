package com.fitnessgeek.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Named;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fitnessgeek.dto.Activity;

import src.com.fitnessgeek.ui.AddUser;
import src.com.fitnessgeek.ui.Logger;


/**
 * Our Activity DAO class 
 * Contains the methods necessary to implement the ActivityDAO
 */
@Named
public class ActivityDAO implements IActivityDAO {
	final static Logger logger = Logger.getLogger(ActivityDAO.class);

	public List<Activity> activities;
	
	public ActivityDAO() {
		activities = new ArrayList<Activity>();
	}
	
	/**
	 * No return on this method.
	 * Inserts an activity into our list of activities
	 * @param avtivity 
	 */ 
	@Override
	public void insert(Activity activity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(activity);
		
		
		session.getTransaction().commit();
		activities.add(activity);
		logger.info("INFO: Activity inserted into list");
	}
	
	/**
	 * No return on this method
	 * Deletes an activity from our activity list
	 * @param activity 
	 */
	@Override
	public void delete(Activity activity) {
		logger.info("INFO: Activity deleted from list");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(activity);
		session.getTransaction().commit();
	}
	
	/**
	 * Returns a list of all our activities
	 * @return a list of activites
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Activity> fetchAllActivities(){
		Session session = HibernateUtil.getSessionFactory().openSession();

		Query query = session.createQuery("FROM Activity");

		@SuppressWarnings("rawtypes")
		List list = query.list();
		
		activities = Collections.checkedList(list, Activity.class);
		
		session.close();
		return activities;
	}

}
