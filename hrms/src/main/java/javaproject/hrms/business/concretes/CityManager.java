package javaproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaproject.hrms.business.abstracts.CityService;
import javaproject.hrms.core.utilities.results.DataResult;
import javaproject.hrms.core.utilities.results.SuccessDataResult;
import javaproject.hrms.dataAccess.abstracts.CityDao;
import javaproject.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		
		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}

	@Override
	public DataResult<City> getCityById(int cityId) {
		
		return new SuccessDataResult<City>(this.cityDao.getOne(cityId));
	}

}
