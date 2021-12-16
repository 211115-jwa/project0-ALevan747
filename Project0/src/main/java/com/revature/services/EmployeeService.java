package com.revature.services;

import com.revature.beans.Candy;

public interface EmployeeService {
	//what actions can an employee execute?
	public int addNewCandy(Candy newCandy);
	public Candy editCandy(Candy candyToEdit);
	public Candy getCandyById(int id);
}
