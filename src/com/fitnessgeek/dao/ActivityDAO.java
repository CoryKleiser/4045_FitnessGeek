package com.fitnessgeek.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Named;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fitnessgeek.dto.Activity;



@Named
public class ActivityDAO implements IActivityDAO {

	public List<Activity> activities;
	
	public ActivityDAO() {
		activities = new ArrayList<Activity>();
	}
	
	@Override
	public void insert(Activity activity) {
		// TODO Implement Hibernate
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(activity);
		
		
		session.getTransaction().commit();
		activities.add(activity);
	}
	@Override
	public void delete(Activity activity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(activity);
		session.getTransaction().commit();
	}
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
