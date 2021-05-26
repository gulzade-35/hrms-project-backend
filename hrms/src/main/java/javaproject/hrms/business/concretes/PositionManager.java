package javaproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaproject.hrms.business.abstracts.PositionService;
import javaproject.hrms.dataAccess.abstracts.PositionDao;
import javaproject.hrms.entities.concretes.Position;

@Service
public class PositionManager implements PositionService {

	private PositionDao positionDao;
	
	@Autowired
	public PositionManager(PositionDao positionDao) {
		super();
		this.positionDao = positionDao;
	}

	@Override
	public List<Position> getAll() {
		// TODO Auto-generated method stub
		return this.positionDao.findAll();
	}

}
