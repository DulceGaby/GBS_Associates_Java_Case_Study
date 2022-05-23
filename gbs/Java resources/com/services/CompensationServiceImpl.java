package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Compensation;
import com.dao.CompensationDao;

@Service
public class CompensationServiceImpl implements CompensationService {

	@Autowired
	private CompensationDao dao;

	public CompensationDao getDao() {
		return dao;
	}

	public void setDao(CompensationDao dao) {
		this.dao = dao;
	}

	@Override
	public Compensation findCompensation(int id) {
		return dao.findCompensation(id);
	}

	@Override
	public int save(Compensation compensation) {
		return dao.create(compensation);
	}

	@Override
	public List<Compensation> getCompensationPerEmployee(int idEmployee) {
		return dao.findPerEmployee(idEmployee);
	}

	@Override
	public int update(Compensation compensation, int id) {
		return dao.edit(compensation, id);
	}

	@Override
	public List<Compensation> getCompensationsEmployee(int idEmployee) {
		return dao.compensationsEmployee(idEmployee);
	}


}
