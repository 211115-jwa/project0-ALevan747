package com.revature.services;

import java.util.Set;

import com.revature.beans.Candy;
import com.revature.beans.User;

public interface UserService {
	//what can a user do?
	public User register(User newUser);
	public User logIn(String Username, String Password);
	public User updateUser(User userToUpdate);
	public User buyCandy(int Id, User newBuyer);
	public Set<Candy> viewAvailableCandy();
	public Set<Candy> searchAvailableCandybyFlavor(String Flavor);
	

}
