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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User logIn(String Username, String Password) {
		User userFromDatabase = userDAO.getByUsername(Username);
		if(userFromDatabase != null && userFromDatabase.getPassword().equals(Password)) {
			return userFromDatabase;
		}
		return null;
	}
	@Override
	public User updateUser(User userToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User buyCandy(int Id, User newBuyer) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Set<Candy> viewAvailableCandy() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Set<Candy> searchAvailableCandybyFlavor(String Flavor) {
		// TODO Auto-generated method stub
		return null;
	}
}
