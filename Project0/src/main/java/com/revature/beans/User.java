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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + id;
		result = prime * result + ((Username == null) ? 0 : Username.hashCode());
		result = prime * result + ((Password == null) ? 0 : Password.hashCode());
		result = prime * result + ((Candy == null) ? 0 : Candy.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (id != other.id)
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (Candy == null) {
			if (other.Candy != null)
				return false;
		} else if (!Candy.equals(other.Candy))
			return false;
		if (Username == null) {
			if (other.Username != null)
				return false;
		} else if (!Username.equals(other.Username))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", Name=" + Name + ", Username=" + Username + ", Password=" + Password
				+ ", Candy=" + Candy + "]";
	}
}
