package javaproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaproject.hrms.business.abstracts.JobTitleService;
import javaproject.hrms.core.utilities.results.DataResult;
import javaproject.hrms.core.utilities.results.ErrorResult;
import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.core.utilities.results.SuccessDataResult;
import javaproject.hrms.core.utilities.results.SuccessResult;
import javaproject.hrms.dataAccess.abstracts.JobTitleDao;
import javaproject.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {

		return new SuccessDataResult<List<JobTitle>> (this.jobTitleDao.findAll());
	}

	@Override
	public Result add(JobTitle jobTitle) {
	
		if(!this.isTitleExist(jobTitle.getTitleName())) {
			
			return new ErrorResult("İş unvanı var.");
		}
		
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("İş unvanı eklendi.");
	}

	private boolean isTitleExist(String titleName) {
		if(this.jobTitleDao.findByTitleName(titleName) != null) {
			return false;
		}
		return true;
	}

	@Override
	public DataResult<JobTitle> getJobTitleById(int jobTitleId) {
		return new SuccessDataResult<JobTitle>(this.jobTitleDao.getOne(jobTitleId));
	}

}
