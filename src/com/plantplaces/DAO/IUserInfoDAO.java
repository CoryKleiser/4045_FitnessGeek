package com.plantplaces.DAO;

import java.util.List;

import com.plantplaces.DTO.User;

/**
* This class gets users from the database; create, update, and delete users
*/
public interface IUserInfoDAO {

	public List<User> getUsers() throws Exception;
	
	public void insert(User user) throws Exception;
	
	public void update(User user) throws Exception;
	
	public void delete(User user) throws Exception;
}
