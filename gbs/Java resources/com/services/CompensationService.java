package com.services;

import com.dto.Compensation;

public interface CompensationService {
	
	int save(Compensation compensation);

	Compensation findCompensation(int id);
}
