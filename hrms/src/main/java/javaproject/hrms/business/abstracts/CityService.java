package javaproject.hrms.business.abstracts;

import java.util.List;

import javaproject.hrms.core.utilities.results.DataResult;
import javaproject.hrms.entities.concretes.City;

public interface CityService {

	DataResult<List<City>> getAll();
	
	DataResult<City> getCityById (int cityId);
}
