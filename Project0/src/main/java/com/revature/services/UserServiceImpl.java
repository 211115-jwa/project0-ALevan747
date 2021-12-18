package com.revature.services;

import java.util.Set;

import com.revature.beans.Candy;
import com.revature.beans.User;
import com.revature.data.CandyDAO;
import com.revature.data.UserDAO;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;
	private CandyDAO candyDAO;
	
	@Override
	public User register(User newUser) {
		int newId = userDAO.create(newUser);
		if (newId != 0) {
			newUser.setId(newId);
			return newUser;
		}
		return null;
	}
	@Override
	public User logIn(String username, String password) {
		User userFromDatabase = userDAO.getByUsername(username);
		if(userFromDatabase != null && userFromDatabase.getPassword().equals(password)) {
			return userFromDatabase;
		}
		return null;
	}
	@Override
	public User updateUser(User userToUpdate) {
		if(userDAO.getById(userToUpdate.getId()) != null) {
			userDAO.update(userToUpdate);
			userToUpdate = userDAO.getById(userToUpdate.getId());
			return userToUpdate;
		}
		return null;
	}
	@Override
	public User buyCandy(int Id, User newBuyer) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Set<Candy> viewAvailableCandy() {  //add available to database 
		return candyDAO.getByStatus("Available");
	}
	@Override
	public Set<Candy> searchAvailableCandybyFlavor(String Flavor) {
		Set<Candy> availableCandy = candyDAO.getByStatus("Available");
		return null;
	}
}
