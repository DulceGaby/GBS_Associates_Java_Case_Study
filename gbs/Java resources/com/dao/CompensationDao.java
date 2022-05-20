package com.dao;

import com.dto.Compensation;

public interface CompensationDao {

	int  create(Compensation compensation);
	
	Compensation findCompensation(int id);
}
