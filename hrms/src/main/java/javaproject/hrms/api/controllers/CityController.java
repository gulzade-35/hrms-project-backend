package javaproject.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javaproject.hrms.business.abstracts.CityService;
import javaproject.hrms.core.utilities.results.DataResult;
import javaproject.hrms.entities.concretes.City;

@RestController

@RequestMapping("api/cities")
public class CityController {

	private CityService cityService;

	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<City>> getAll(){
		return this.cityService.getAll();
	}
	
	@GetMapping("/getByCityId")
	public DataResult<City> getByCityId(@RequestParam("cityId") int cityId){
		
		return this.cityService.getCityById(cityId);
	}
	 
	
}
