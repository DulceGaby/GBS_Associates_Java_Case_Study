package com.dao;

import java.util.List;

import com.dto.Compensation;

public interface CompensationDao {

	int  create(Compensation compensation);
	
	Compensation findCompensation(int id);
	
	List<Compensation> findPerEmployee(int idEmployee); 
	
	int edit(Compensation compensation, int id);
}
