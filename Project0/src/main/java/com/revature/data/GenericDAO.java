package com.revature.data;

import java.util.Set;

public interface GenericDAO<D> {
	//CRUD operations should be used to access database
	public int create(D dataToAdd);
	public D getById(int id);
	public Set<D> getAll();
	public void update(D dataToUpdate);
	public void delete(D dataToDelete);

}