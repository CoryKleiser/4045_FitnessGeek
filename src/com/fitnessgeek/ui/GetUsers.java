package com.fitnessgeek.ui;

import java.util.Set;

import javax.annotation.ManagedBean;
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

	public Set<User> getUsers() {
		users = userService.showAllUsers();
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
