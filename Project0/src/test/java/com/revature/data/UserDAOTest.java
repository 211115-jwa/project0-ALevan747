package com.revature.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals; //on hold until getALLNotNull is fixed
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import com.revature.beans.User;
import com.revature.data.postgres.UserPostgres;

//@testmethodorder(Alphanumeric.class)
//@testmethodorder(orderannotation.class)

public class UserDAOTest {
	private UserDAO userDAO = new UserPostgres();
	
	@Test
	public void getAllNotNull() {
		System.out.println("Underconstruction due to static issue");
		//Set<User> actual = UserDAO.getAll();
		//assertNotEquals(null, actual);
	}
	
	@Test
	public void getValidUserById() {
		String expectedUsername = "Andre";
		User actual = userDAO.getById(1);
		assertEquals(expectedUsername, actual.getUsername());
	}
	
	@Test
	public void testUpdate() {
		User userUpdate = userDAO.getById(1);
		userUpdate.setName("Andre2");
		userDAO.update(userUpdate);
		assertEquals("Andre2",userDAO.getById(1).getName());
	}
	
	@Test
	public void testGetIdnoId() {
		User userOutput = userDAO.getById(10000);
		assertNull(userOutput);
	}
	
	@Test
	public void createTest() {
		User create = new User();
		assertNotEquals(0, userDAO.create(create));
		//use userdao to test that create method is not null
	}
	
	@Test
	public void getByUsernameWhenUsernameExists() {
		//setup
		String UsernameInput = "Andre";
		//call the method we're testing
		User userOutput = userDAO.getByUsername(UsernameInput);
		//assert that it did what we expected it to do
		assertEquals("Andre", userOutput.getUsername());
		//still has issues
	}
	

	public void getByUsernameButUsernameDoesNotExist() {
		String usernameInput = "qazwsxedcrfv";
		User userOutput = userDAO.getByUsername(usernameInput);
		assertNull(userOutput);
	}
}

