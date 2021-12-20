package com.revature.data;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.Set;
import org.junit.jupiter.api.Test;
import com.revature.beans.Candy;
import com.revature.data.postgres.CandyPostgres;

public class CandyDAOTest {
	private CandyDAO candyDAO = new CandyPostgres();
	
	//@Test
	//setup, call and assert
	//public void getByIdWhenIdExists() {
		//int idInput = 1;
		//Candy idOutput = candyDAO.getById(idInput);
		//assertEquals(1,idOutput.getId());
	//}
	
	@Test
	public void getByIdWhenIdDoesNotExists() {
		int idInput = -1;
		Candy candyOutput = candyDAO.getById(idInput);
		assertNull(candyOutput);
	}
	
	@Test
	public void getAll() {
		Set<Candy> givenOutput = candyDAO.getAll();
		assertNotNull(givenOutput);
	}
	
	@Test
	public void addNewCandy() {
		Candy newCandy = new Candy();
		System.out.println(newCandy);
		
		int generatedId = candyDAO.create(newCandy);
		
		assertNotEquals(0, generatedId);
		System.out.println(generatedId);
	}

}
