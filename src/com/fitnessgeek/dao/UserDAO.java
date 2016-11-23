package com.fitnessgeek.dao;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Named;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fitnessgeek.dto.User;

/**
 * User hibernate DAO class
 * @author moku
 *
 */
@Named
public class UserDAO implements IUserDAO{

	
	public Set<User> users;
	
	/**
	 * Default constructor. Sets our users variable to a new HashSet
	 * No return
	 */
	public UserDAO() {
		users = new HashSet<User>();
	}
	
	/**
	 * Fetches all users
	 * @return users
	 */
	@Override
	public Set<User> fetchAllUsers(){
		return users;
	}
	
	/**
	 * Inserts a new user
	 * @param user
	 * No return
	 */
	@Override
	public void insert(User user){
		//save user to database
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(user);
		users.add(user);
		
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * Gets (returns) a single user
	 * @param String username
	 * @return user
	 */
	@Override
	public User getSingleUser(String userName){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		User user = (User) session
				.createQuery("FROM User WHERE userName ='"+ userName + "'")
				.uniqueResult();
		
		session.close();
		return user;
	}

}
