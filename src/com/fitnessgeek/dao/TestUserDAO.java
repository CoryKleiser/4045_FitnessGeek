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

	private String oneUserNameUid = UUID.randomUUID().toString();
	private String twoUserNameUid = UUID.randomUUID().toString();

	private User singleUser;

	/**
	 * This test method runs all of our tests
	 */
	@Test
	public void runUnitTest() {
		givenUserDAOIsMadeWithUsers();
		fetchAllUsers();
		fetchSingleUserByUserId();
		verifyResults();
	}
	
	/**
	 * This test method fetches a user by their id
	 */ 
	private void fetchSingleUserByUserId() {
		singleUser = userDAO.getSingleUser(oneUserNameUid);
	}

	/**
	 * This test method verifies our results
	 */
	private void verifyResults() {
		Boolean userOneFound = false;
		Boolean userTwoFound = false;
		
		Boolean twoUsersFound = false;
		Boolean singleUserFound = false;
		
		Boolean singleAndTwoUsersFound = false;
		
		//Check to see if the two users added, are there
		if (users.size() > 1) {
			for (User user : users) {
				if (user.getUserName().equals(oneUserNameUid)) {
					userOneFound = true;
				}
				else if (user.getUserName().equals(twoUserNameUid)) {
					userTwoFound = true;
				}
			}
		}
		
		//Verify both users were found
		if (userOneFound == true && userTwoFound == true){
			twoUsersFound = true;
		}
		
		//check to see if getting one user worked
		if(singleUser != null){
			if (singleUser.getUserName().equals(oneUserNameUid)){
				singleUserFound = true;
			}
		}
		
		if(twoUsersFound == true && singleUserFound == true){
			singleAndTwoUsersFound = true;
		}

		Assert.assertEquals(true, singleAndTwoUsersFound);


	}

	/**
	 * This test method fetches all users
	 */
	private void fetchAllUsers() {
		users = userDAO.fetchAllUsers();

	}

	/**
	 * This test method tests user creation with our DAO
	 */
	private void givenUserDAOIsMadeWithUsers() {
		userDAO = new UserDAO();

		User firstUser = new User();

		firstUser.setEmail(oneUserNameUid + "@mail.uc.edu");
		firstUser.setFirstName("UNIT TEST");
		firstUser.setLastName("UNIT TEST");
		firstUser.setPassword("UNIT TEST");
		firstUser.setUserHeight(55);
		firstUser.setUserName(oneUserNameUid);
		firstUser.setUserWeight(150);

		userDAO.insert(firstUser);

		User secondUser = new User();

		secondUser.setEmail(twoUserNameUid + "@mail.uc.edu");
		secondUser.setFirstName("UNIT TEST");
		secondUser.setLastName("UNIT TEST");
		secondUser.setPassword("UNIT TEST");
		secondUser.setUserHeight(55);
		secondUser.setUserName(twoUserNameUid);
		secondUser.setUserWeight(150);

		userDAO.insert(secondUser);

	}

}
