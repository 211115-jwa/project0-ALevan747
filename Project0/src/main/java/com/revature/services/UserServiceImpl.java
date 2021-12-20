package com.revature.services;

import java.util.HashSet;
import java.util.Set;

import com.revature.beans.Candy;
import com.revature.beans.User;
import com.revature.data.CandyDAO;
import com.revature.data.UserDAO;
import com.revature.data.postgres.CandyPostgres;
import com.revature.data.postgres.UserPostgres;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO = new UserPostgres();
	private CandyDAO candyDAO = new CandyPostgres();
	
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
	//@Override
	//public Set<Candy> viewAllCandy() {  //add instock yes no to database, default yes. Change to instock?
		//return candyDAO.getInStock("Yes");
	//}
	@Override
	public Set<Candy> searchAllCandybyFlavor(String flavor) {
		Set<Candy> inStockCandy = candyDAO.getInStock("yes");
		//not streaming here
		Set<Candy> candyByFlavor = new HashSet<>();
		for(Candy candy : inStockCandy) {
			if(candy.getFlavor().toLowerCase().contains(flavor.toLowerCase())) {
				candyByFlavor.add(candy);
			}
		}
		return inStockCandy;
	}
	@Override
	public Set<Candy> searchAvailableCandybyFlavor(String Flavor) { //example that is obsolete with searchallCandyByFlavor
		//to stream? or not to stream?
		return null;
	}
	@Override
	public Set<Candy> getAll() {
		return candyDAO.getAll();
	}
}
