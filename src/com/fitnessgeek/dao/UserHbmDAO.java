package com.fitnessgeek.dao;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Named;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fitnessgeek.dto.User;

/**
 * User hibernate DAO class
 * 
 * @author moku
 *
 */
@Named
public class UserHbmDAO implements IUserDAO {

	@Override
	public Set<User> fetchAllUsers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from User");
		
		@SuppressWarnings("unchecked")
		Set<User> users = new HashSet<User>(query.list());
				
		session.getTransaction().commit();
		session.close();

		return users;
	}

	@Override
	public void insert(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(user);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public User getSingleUser(String userName) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		User user = (User) session.createQuery("FROM User WHERE userName ='" + userName + "'").uniqueResult();

		session.close();
		return user;
	}

}
