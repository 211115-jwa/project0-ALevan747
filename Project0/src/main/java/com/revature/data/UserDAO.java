package com.revature.data;

import com.revature.beans.User;

public interface UserDAO extends GenericDAO<User>{
	public User getByUsername(String Username);
	//public User getByName(String Name); //add into further files

}
