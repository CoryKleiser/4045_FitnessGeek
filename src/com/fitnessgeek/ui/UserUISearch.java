package com.fitnessgeek.ui;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.fitnessgeek.dto.User;
import com.fitnessgeek.services.UserService;

/**
 * This class is used for our user search
 *
 */
@Named
@ManagedBean
@Scope("session")
public class UserUISearch {

	@Inject
	private User user;

	@Inject
	private UserService userService;

	private List<User> users;

	/**
	 * Do user search
	 */
	public String execute() {
		setUsers(userService.getFilteredUsers(getUser().getUserName()));

		if (getUsers().size() < 1) {
			return "noresults";
		} else {
			return "usersearch";
		}
	}

	/**
	 * Get filtered list of users for auto complete
	 *
	 */
	public List<User> completeUser(String query) {
		return userService.getFilteredUsers(query);
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
