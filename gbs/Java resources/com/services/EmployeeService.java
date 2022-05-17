package com.services;

import java.util.List;

import com.dto.Employee;

public interface EmployeeService {

	int save(Employee employee);
	
	List<Employee> getEmployees();
	
	Employee getEmployee(String firstName);
}
