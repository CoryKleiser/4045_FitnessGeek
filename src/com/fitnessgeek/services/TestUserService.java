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
 * @author williwm
 *
 */
public class TestUserService {
	
	private UserService userService;
	
	private IUserDAO userDAO;
	
	private Set<User> users;
	
	@Test
	public void runUnitTest(){
		givenUserServiceIsPopulatedWithADAO();
		getUser();
		verifyResults();
	}



	private void getUser() {
		users = userService.showAllUsers();
	}



	private void verifyResults() {
		Assert.assertEquals(1, users.size());
	}


	private void givenUserServiceIsPopulatedWithADAO() {
		userService = new UserService();
		
		userDAO = mock(IUserDAO.class);
		
		userService.setUserDAO(userDAO);
		
		when(userDAO.fetchAllUsers()).thenReturn(constructUserList());
		
		User user = new User();
		
		user.setUserId(123456);
		
		userService.add(user);
		
	}
	
	private Set<User> constructUserList(){
		
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
