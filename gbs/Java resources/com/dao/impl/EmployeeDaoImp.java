package com.dao.impl;

import com.dao.EmployeeDao;
import com.dto.Employee;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class EmployeeDaoImp implements EmployeeDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public int create(Employee employee) {
		Integer result= (Integer) hibernateTemplate.save(employee);
		return result;
	}
	
}
