package com.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EmployeeDao;
import com.dto.Employee;


@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	@Transactional
	public int create(Employee employee) {
		Integer result = (Integer) hibernateTemplate.save(employee);
		return result;
	}

	@Override
	public Employee findEmployee(String firstName) {
		return hibernateTemplate.get(Employee.class, 16);
	}

	@Override
	public List<Employee> findEmployees() {
		return hibernateTemplate.loadAll(Employee.class);
	}
}
