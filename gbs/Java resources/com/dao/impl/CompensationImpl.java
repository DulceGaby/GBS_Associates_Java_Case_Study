package com.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Compensation> findPerEmployee(int idEmployee) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Compensation.class);
	    criteria.add(Restrictions.eq("idEmployee", idEmployee));
	    criteria.add(Restrictions.eq("type", "Salary"));
	    return (List<Compensation>) getHibernateTemplate().findByCriteria(criteria);
	}


}
