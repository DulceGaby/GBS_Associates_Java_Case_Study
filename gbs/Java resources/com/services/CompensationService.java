package com.services;

import java.util.List;

import com.dto.Compensation;

public interface CompensationService {
	
	int save(Compensation compensation);

	Compensation findCompensation(int id);
	
	List<Compensation> getCompensationPerEmployee(int idEmployee); 
	
	List<Compensation> getCompensationsEmployee(int idEmployee); 
	
	int update(Compensation compensation, int id);
}
