package com.revature.services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.revature.beans.Candy;
import com.revature.beans.User;
import com.revature.data.CandyDAO;
import com.revature.data.UserDAO;

//telling JUnit that we are using Mokito
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	//tell mockito which classes/interfaces that we'll be mocking
	@Mock
	private CandyDAO candyDAO;
	
	@Mock
	private UserDAO userDAO;
	
	//tell mockito to voerride thr regular DAO's with our mock DAO's
	@InjectMocks
	private UserService userServ = new UserServiceImpl();
	
	private static Set<Candy> mockAllCandy;
	
	@BeforeAll
	public static void mockAvailableCandySetup() {
		mockAllCandy = new HashSet<>();
		
		for(int i=1; i <= 5; i++) {
			Candy candy = new Candy();
			candy.setId(i);
			if(i<3)
				candy.setFlavor("cherry");
			mockAllCandy.add(candy);
		}	
	}
	
	@Test
	public void logInSuccessfully() {
		// input setup
		String username="qwertyuiop";
		String password="pass";
		
		// set up the mocking
		User mockUser = new User();
		mockUser.setUsername(username);
		mockUser.setPassword(password);
		when(userDAO.getByUsername(username)).thenReturn(mockUser);
		
		// call the method we're testing
		User actualUser = userServ.logIn(username, password);
		
		// assert the expected behavior/output
		assertEquals(mockUser,actualUser);
	}
	
	@Test
	public void logInIncorrectPassword() {
		String username="qwertyuiop";
		String password="12345";
		
		User mockUser = new User();
		mockUser.setUsername(username);
		mockUser.setPassword("pass");
		when(userDAO.getByUsername(username)).thenReturn(mockUser);
		
		User actualUser = userServ.logIn(username, password);
		assertNull(actualUser);
	}
	
	@Test
	public void logInUsernameDoesNotExist() {
		String username="asdfghjkl";
		String password="pass";
		
		when(userDAO.getByUsername(username)).thenReturn(null);
		
		User actualUser = userServ.logIn(username, password);
		assertNull(actualUser);
	}
	
	@Test
	public void registerUserSuccessfully() {
		User user = new User();
		
		when(userDAO.create(user)).thenReturn(10);
		
		User actualUser = userServ.register(user);
		assertEquals(10, actualUser.getId());
	}
	
	@Test
	public void registerUserSomethingWrong() {
		User user = new User();
		when(userDAO.create(user)).thenReturn(0);
		User actualUser = userServ.register(user);
		assertNull(actualUser);
	}
	
	@Test
	public void searchByFlavorExists() {
		String flavor = "Blue Berry";
		
		//when(userDAO.getInStock("yes")).thenReturn(mockAvailablePets); add status? or swap with instock?
		
		//Set<Candy> actualCats = userServ.searchAvailablePetsBySpecies(species);
		//boolean onlyCats = true;        redo in Flavor terms
		//for (Pet pet : actualCats) {
		//	if (!pet.getSpecies().equals(species))
			//	onlyCats = false;
		//}
		
		//assertTrue(onlyCats);
	}
	
	//@Test
	//public void searchByFlavorDoesNotExist() { //actual candy fault
		//String flavor = "qwertyuiop";
		
		//when(candyDAO.getByStatus("Available")).thenReturn(mockAvailableCandy);
		
		//Set<Candy> actualCandy = userServ.searchAvailableCandybyFlavor(flavor);
		//assertTrue(actualCandy.isEmpty());
	//}
	
	//have alternate to adopting pet in candy form?
	//Then verify "adoption"?
	
	@Test
	public void updateSuccessfully() {
		User mockUser = new User();
		mockUser.setId(1);
		
		doNothing().when(userDAO).update(Mockito.any(User.class));
		when(userDAO.getById(1)).thenReturn(mockUser);
		
		User user = new User();
		user.setId(1);
		user.setUsername("qwertyuiop");
		User updatedUser = userServ.updateUser(user);
		assertNotEquals(user, updatedUser);
	}
	
	@Test
	public void updateSomethingWrong() {
		User mockUser = new User();
		mockUser.setId(1);
		
		doNothing().when(userDAO).update(Mockito.any(User.class));
		when(userDAO.getById(1)).thenReturn(mockUser);
		
	    User user = new User();
		user.setId(1);
		user.setUsername("qwertyuiop");
		User updatedUser = userServ.updateUser(user);
		assertNotEquals(user, updatedUser);
	}
	
	//@Test
	//public void getAll() {
	//	when(candyDAO.getInStock("yes")).thenReturn(mockAllCandy); //again a status or inStock boolean equivalent is needed
		
	//	Set<Candy> actualCandy = userServ.getAll();
		
	//	assertEquals(mockAllCandy, actualCandy);
	//}
	

}
