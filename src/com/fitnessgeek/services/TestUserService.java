package com.fitnessgeek.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import com.fitnessgeek.dao.IUserDAO;
import com.fitnessgeek.dto.User;

/**
 * This unit test, tests the methods of the UserSerivce Class
 * 
 * @author williwm
 *
 */
public class TestUserService {

	private UserService userService;

	private IUserDAO userDAO;

	private Set<User> users;

	/**
	 * This method runs our unit test
	 */
	@Test
	public void runUnitTest() {
		givenUserServiceIsPopulatedWithADAO();
		getUser();
		verifyResults();
	}

	/**
	 * This method gets a user. It is a helper method and is used in our Unit
	 * Test
	 */
	private void getUser() {
		users = userService.showAllUsers();
	}

	/**
	 * This method is called in our unit tests, after our helper methods. It
	 * verifies that a user was successfully created and added to our list.
	 */
	private void verifyResults() {
		Assert.assertEquals(1, users.size());
	}

	/**
	 * This method populates our DAO given a user It is a helper method and is
	 * used in our Unit Test
	 */
	private void givenUserServiceIsPopulatedWithADAO() {
		userService = new UserService();

		userDAO = mock(IUserDAO.class);

		userService.setUserDAO(userDAO);

		when(userDAO.fetchAllUsers()).thenReturn(constructUserList());

		User user = new User();

		user.setUserId(123456);

		userService.add(user);

	}

	/**
	 * This method creates a new user and List of Users, and adds a user to the
	 * list. It is a helper method and is used in our Unit Test
	 */
	private Set<User> constructUserList() {

		Set<User> users = new HashSet<User>();

		User user = new User();

		user.setEmail("unitTest@mail.uc.edu");
		user.setFirstName("UNIT TEST");
		user.setLastName("UNIT TEST");
		user.setPassword("UNIT TEST");
		user.setUserHeight(55);
		user.setUserName("UNIT TEST");
		user.setUserWeight(150);

		users.add(user);

		return users;
	}
}
