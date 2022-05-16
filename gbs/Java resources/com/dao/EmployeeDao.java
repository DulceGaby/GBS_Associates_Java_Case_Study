package com.dao;

import com.dto.Employee;

public interface EmployeeDao {
	
	int  create(Employee employee);
	
	Employee findEmployee(String firstName);
}
