package com.services;

import java.util.List;

import com.dto.Employee;

public interface EmployeeService {

	int save(Employee employee);
	
	List<Employee> getEmployees();
	
	List<Employee> filterEmployees(String firstName, String lastName, String position);
	
	Employee getEmployee(String firstName, String middleName, String lastName, String birthDate);
	
	Employee viewEmployee(int id);
	
	int update(Employee employee, int id);
}
