package com.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EmployeeDao;
import com.dto.Compensation;
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
	public Employee findEmployee(String firstName, String middleName, String lastName, String birthDate) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
	    criteria.add(Restrictions.eq("firstName", firstName));
	    criteria.add(Restrictions.eq("middleName", middleName));
	    criteria.add(Restrictions.eq("lastName", lastName));
	    criteria.add(Restrictions.eq("birthDate", birthDate));
	    return (Employee) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	}

	@Override
	public List<Employee> findEmployees() {
		return hibernateTemplate.loadAll(Employee.class);
	}

	@Override
	public Employee viewEmployee(int id) {
		return hibernateTemplate.get(Employee.class, id);
	}

	@Override
	@Transactional(readOnly = false)
	public int edit(Employee employee, int id) {
		hibernateTemplate.update(employee);
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> filterEmployees(String firstName, String lastName, String position) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
	    if(firstName != "")
	    	criteria.add(Restrictions.eq("firstName", firstName));
	    if(lastName != "")
	    	criteria.add(Restrictions.eq("lastName", lastName));
	    if(position != "")
	    	criteria.add(Restrictions.eq("position", position));
	    return (List<Employee>) getHibernateTemplate().findByCriteria(criteria);
	}

}
