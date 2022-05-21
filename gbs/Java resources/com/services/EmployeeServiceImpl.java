package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EmployeeDao;
import com.dto.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao dao;

	public EmployeeDao getDao() {
		return dao;
	}

	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public int save(Employee employee) {
//		Business Logic
		return dao.create(employee);
	}

	@Override
	public Employee getEmployee(String firstName, String middleName, String lastName, String birthDate) {
		return dao.findEmployee(firstName, middleName, lastName, birthDate);
	}

	@Override
	public List<Employee> getEmployees() {
		return dao.findEmployees();
	}

	@Override
	public Employee viewEmployee(int id) {
		return dao.viewEmployee(id);
	}

	@Override
	public int update(Employee employee, int id) {
		return dao.edit(employee, id);
		
	}

	@Override
	public List<Employee> filterEmployees(String firstName, String lastName, String position) {
		return dao.filterEmployees(firstName, lastName, position);
	}

}
