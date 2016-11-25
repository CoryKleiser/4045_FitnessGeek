package com.fitnessgeek.ui;

import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.fitnessgeek.dto.User;
import com.fitnessgeek.services.IUserService;

@Named
@ManagedBean
@Scope("session")
/**
 * test class for time being
 * @author moku
 *
 */
public class GetUsers {

	@Inject
	private IUserService userService;
	
	private Set<User> users;

	/**
	 * This method returns a list of all our users
	 * @return Set<User>
	 */
	public Set<User> getUsers() {
		users = userService.showAllUsers();
		return users;
	}

	/**
	 * This method takes in a List of Users and sets our User List equal to that value
	 * @param Set<User> users
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
