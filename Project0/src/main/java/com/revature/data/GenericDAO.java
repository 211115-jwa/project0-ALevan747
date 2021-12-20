package com.revature.data;

import java.util.Set;

public interface GenericDAO<DAO> {
	//CRUD operations should be used to access database
	public int create(DAO dataToAdd);
	public DAO getById(int id);
	public Set<DAO> getAll();
	public void update(DAO dataToUpdate);
	public void delete(DAO dataToDelete);

}
