package javaproject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javaproject.hrms.business.abstracts.JobTitleService;
import javaproject.hrms.core.utilities.results.DataResult;
import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.entities.concretes.JobTitle;

@RestController

@RequestMapping("api/jobtitles")

public class JobTitleController {

	private JobTitleService jobTitleService;

	@Autowired
	public JobTitleController(JobTitleService jobTitleService) {  
		super();
		this.jobTitleService = jobTitleService;
	}
	

	@GetMapping("/getall")
	
	public List<JobTitle> getAll(){
		
		return this.jobTitleService.getAll().getData();
	}
	
	
	@PostMapping("/add")
	public Result registerCandidate(@RequestBody JobTitle jobTitle) {
		
		return this.jobTitleService.add(jobTitle);
				
	}
	
	
	@GetMapping("/getByJobTitleId")
	public DataResult<JobTitle> getByCityId(@RequestParam("jobTitleId") int jobTitleId){
		return this.jobTitleService.getJobTitleById(jobTitleId);
	}
}
