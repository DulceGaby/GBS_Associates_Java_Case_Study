package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EmployeeDao;
import com.dto.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {
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
		//Business Logic
		return dao.create(employee);
	}
}
