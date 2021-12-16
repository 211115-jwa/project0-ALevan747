package com.revature.beans;

import java.util.List;

public class User {
	private int id;
	private String Name;
	private String Username;
	private String Password;
	private List<Candy> Candy;
	


	public User() {
		id = 0;
		Name = "Name";
		Username = "Username";
		Password = "Password";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	public List<Candy> getCandy() {
		return Candy;
	}


	public void setCandy(List<Candy> candy) {
		Candy = candy;
	}
	
	//add hashcode override
}
