package com.fitnessgeek.dao;

import java.util.Set;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import com.fitnessgeek.dto.User;

/**
 * This unit test, tests the methods of the User DAO
 * 
 * @author williswm
 *
 */
public class TestUserDAO {

	private UserDAO userDAO;

	private Set<User> users;
	
	private Boolean userFound = false;

	private String userNameUid = UUID.randomUUID().toString();

	@Test
	public void runUnitTest() {
		givenUserDAOIsMadeWithAUser();
		fetchUser();
		verifyResults();
	}

	private void verifyResults() {
		
		users = userDAO.fetchAllUsers();

		for (User user : users) {
			if(user.getUserName().equals(userNameUid)){
				userFound = true;
				break;
			}		
		}
		
		Assert.assertEquals(true, userFound);

	}

	private void fetchUser() {
		users = userDAO.fetchAllUsers();

	}

	private void givenUserDAOIsMadeWithAUser() {
		userDAO = new UserDAO();

		User user = new User();

		user.setEmail(userNameUid + "@mail.uc.edu");
		user.setFirstName("UNIT TEST");
		user.setLastName("UNIT TEST");
		user.setPassword("UNIT TEST");
		user.setUserHeight(55);
		user.setUserName(userNameUid);
		user.setUserWeight(150);

		userDAO.insert(user);

	}

}
