package com.revature.services;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.beans.Candy;
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
	
	private static Set<Candy> mockAvailableCandy;
	
	@BeforeAll
	public static void mockAvailableCandySetup() {
		mockAvailableCandy = new HashSet<>();
		
		for(int i=1; i <= 5; i++) {
			Candy candy = new Candy();
			candy.setId(i);
			if(i<3)
				candy.setFlavor("cherry");
			mockAvailableCandy.add(candy);
		}	
	}
	

}
