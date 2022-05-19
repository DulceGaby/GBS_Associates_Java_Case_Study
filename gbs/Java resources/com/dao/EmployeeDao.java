package com.dao;

import java.util.List;

import com.dto.Employee;

public interface EmployeeDao {
	
	int  create(Employee employee);
	
	List<Employee> findEmployees();
	
	Employee findEmployee(String firstName, String middleName, String lastName, String birthDate);
	
	Employee viewEmployee(int id);
	
	int edit(Employee employee, int id);
}
