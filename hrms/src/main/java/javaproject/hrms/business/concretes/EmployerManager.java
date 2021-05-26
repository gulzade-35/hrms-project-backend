package javaproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaproject.hrms.business.abstracts.EmployerService;
import javaproject.hrms.dataAccess.abstracts.EmployerDao;
import javaproject.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	
	@Autowired
    public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}
	
	@Override
	public List<Employer> getAll() {
		return this.employerDao.findAll();
	}
	
}