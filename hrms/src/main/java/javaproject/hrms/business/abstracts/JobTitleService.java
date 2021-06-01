package javaproject.hrms.business.abstracts;

import java.util.List;

import javaproject.hrms.core.utilities.results.DataResult;
import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.entities.concretes.JobTitle;

public interface JobTitleService {

	DataResult<List<JobTitle>> getAll();
	
	Result add(JobTitle jobTitle);
	
	DataResult<JobTitle> getJobTitleById(int jobTitleId);
}
