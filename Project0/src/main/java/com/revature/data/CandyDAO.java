package com.revature.data;

import java.util.Set;

import com.revature.beans.Candy;

public interface CandyDAO extends GenericDAO<Candy> {
	public Candy getById(int id);
	public Set<Candy> getInStock(String inStock);

}
