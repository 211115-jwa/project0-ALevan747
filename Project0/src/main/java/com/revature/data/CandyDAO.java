package com.revature.data;

import java.util.Set;

import com.revature.beans.Candy;

public interface CandyDAO extends GenericDAO<Candy> {
	public Set<Candy> getByStatus(String status);

}
