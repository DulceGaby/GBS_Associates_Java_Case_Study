package com.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CompensationDao;
import com.dto.Compensation;

@Repository
public class CompensationImpl implements CompensationDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public Compensation findCompensation(int id) {
		return hibernateTemplate.get(Compensation.class, id);
	}

	@Override
	@Transactional
	public int create(Compensation compensation) {
		Integer result = (Integer) hibernateTemplate.save(compensation);
		return result;
	}

}
