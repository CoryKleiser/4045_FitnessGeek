package com.fitnessgeek.dao;

import java.util.HashSet;
import java.util.List;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fitnessgeek.dao.IUserDAO#fetchAllUsers() Fetch all the users
	 * from the DB as a set of User objects.
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fitnessgeek.dao.IUserDAO#insert(com.fitnessgeek.dto.User) Add a
	 * new User to the DB.
	 */
	@Override
	public void insert(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(user);

		session.getTransaction().commit();
		session.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fitnessgeek.dao.IUserDAO#getSingleUser(java.lang.String) Get a
	 * user object from the DB from the username.
	 */
	@Override
	public User getSingleUser(String userName) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		User user = (User) session.createQuery("FROM User WHERE userName ='" + userName + "'").uniqueResult();

		session.close();
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fitnessgeek.dao.IUserDAO#getSingleUser(java.lang.String) Get a
	 * user object from the DB from the username.
	 */

	@Override
	public List<User> getFilteredUsers(String query) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		@SuppressWarnings("unchecked")
		List<User> users = session.createQuery("FROM User WHERE userName like '%" + query + "%'").list();

		session.close();
		return users;
	}

}
