package com.services;

import com.dto.Employee;

public interface EmployeeService {

	int save(Employee employee);
	
	Employee getEmployee(String firstName);
}
