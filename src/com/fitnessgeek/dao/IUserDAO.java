package com.fitnessgeek.dao;

import java.util.Set;

import com.fitnessgeek.dto.User;

/**
 * Interface for our UserDAO
 */
public interface IUserDAO {

	/**
	 * fetches all user
	 * @return HashSet of all users
	 */
	Set<User> fetchAllUsers();

	/**
	 * persist user
	 * @param user
	 */
	void insert(User user);

	/**
	 * @param userName
	 * @return user
	 */
	User getSingleUser(String userName);

}
