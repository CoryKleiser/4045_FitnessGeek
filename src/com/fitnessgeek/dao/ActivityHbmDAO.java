package com.fitnessgeek.dao;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Named;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fitnessgeek.dto.Activity;

@Named
public class ActivityHbmDAO implements IActivityDAO  {

	@Override
	public void insert(Activity activity) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(activity);
		
		session.getTransaction().commit();
		session.close();
		
	}

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

	@Override
	public void delete(Activity activity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.delete(activity);
		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void update(Activity activity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.update(activity);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
