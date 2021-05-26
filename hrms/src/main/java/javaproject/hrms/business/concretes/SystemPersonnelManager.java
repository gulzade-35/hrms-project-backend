package javaproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaproject.hrms.business.abstracts.SystemPersonnelService;
import javaproject.hrms.dataAccess.abstracts.SystemPersonnelDao;
import javaproject.hrms.entities.concretes.SystemPersonnel;

@Service
public class SystemPersonnelManager implements SystemPersonnelService {

	private SystemPersonnelDao systemPersonnelDao;
	
	@Autowired
	public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao) {
		super();
		this.systemPersonnelDao = systemPersonnelDao;
	}

	@Override
	public List<SystemPersonnel> getAll() {
		// TODO Auto-generated method stub
		return this.systemPersonnelDao.findAll();
	}

}
