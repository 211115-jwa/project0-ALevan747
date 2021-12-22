package com.revature.services;

import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.beans.Candy;
import com.revature.data.CandyDAO;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
	@Mock
	private CandyDAO candyDAO;
	
	@InjectMocks
	private EmployeeService empServ = new EmployeeServiceImpl();
	
	@Test
	public void addNewCandySuccessfully() {
		Candy candy = new Candy();
		
		when(candyDAO.create(candy)).thenReturn(10);
		
		int newId = empServ.addNewCandy(candy);
		
		assertNotEquals(0, newId);
	}
	
	@Test
	public void addNewCandySomethingWrong() {
		Candy candy = new Candy();
		
		when(candyDAO.create(candy)).thenReturn(0);
		
		int newId = empServ.addNewCandy(candy);
		
		assertEquals(0,newId);
	}
	
	@Test
	public void editCandyDoesNotExist() {
		when(candyDAO.getById(2)).thenReturn(null);
		
		Candy editedCandy = new Candy();
		editedCandy.setId(2);
		
		Candy actualCandy = empServ.editCandy(editedCandy);
		
		assertNull(actualCandy);
		verify(candyDAO, times(0)).update(Mockito.any(Candy.class));
	}
	
	@Test
	public void getByIdCandyExists() {
		Candy candy = new Candy();
		candy.setId(2);
		
		when(candyDAO.getById(2)).thenReturn(candy);
		
		Candy actualCandy = empServ.getCandyById(2);
		assertEquals(candy, actualCandy);
	}
	
	@Test
	public void getByIdCandyDoesNotExist() {
		when(candyDAO.getById(2)).thenReturn(null);
		
		Candy actualCandy = empServ.getCandyById(2);
		assertNull(actualCandy);
	}
	
	@Test
	public void editCandySuccessfully() {
		//Candy editedCandy = new Candy();
		//editedCandy.setId(2);
		//editedCandy.setId(10);
		
		//when(candyDAO.getById(2)).thenReturn(editedCandy);
		//doNothing().when(candyDAO).update(Mockito.any(Candy.class));
		
		//Candy actualCandy = empServ.editCandy(editedCandy);
		
		//assertEquals(editedCandy, actualCandy);
	}
	
	@Test
	public void editCandySomethingWrong() {
		//Candy mockCandy = new Candy();
		//mockCandy.setId(2);
		
		//when(candyDAO.getById(2)).thenReturn(mockCandy);
		//doNothing().when(candyDAO).update(Mockito.any(Candy.class));
		
		//Candy editedCandy = new Candy();
		//editedCandy.setId(2);
		
		//Candy actualCandy = empServ.editCandy(editedCandy);
		
		//assertNotEquals(editedCandy, actualCandy);
	}
}
