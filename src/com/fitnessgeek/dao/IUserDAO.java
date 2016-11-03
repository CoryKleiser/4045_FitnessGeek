package com.fitnessgeek.dao;

import java.util.Set;

import com.fitnessgeek.dto.User;

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

}