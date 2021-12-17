package com.revature.services;

import com.revature.beans.Candy;
import com.revature.data.CandyDAO;
import com.revature.data.postgres.CandyPostgres;

public class EmployeeServiceTest implements EmployeeService{
	private CandyDAO candyDAO = new CandyPostgres();

	@Override
	public int addNewCandy(Candy newCandy) {
		return candyDAO.create(newCandy);
	}

	@Override
	public Candy editCandy(Candy candyToEdit) {
		Candy candyFromDatabase = candyDAO.getById(candyToEdit.getId());
		if (candyFromDatabase != null) {
			candyDAO.update(candyToEdit);
			return candyDAO.getById(candyToEdit.getId());
		}
		return null;
	}

	@Override
	public Candy getCandyById(int id) {
		return candyDAO.getById(id);
	}

}
