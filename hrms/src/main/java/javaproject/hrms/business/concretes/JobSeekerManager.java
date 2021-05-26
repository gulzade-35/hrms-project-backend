package javaproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaproject.hrms.business.abstracts.jobSeekerService;
import javaproject.hrms.dataAccess.abstracts.JobSeekerDao;
import javaproject.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements jobSeekerService {

	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public List<JobSeeker> getAll() {
		// TODO Auto-generated method stub
		return this.jobSeekerDao.findAll();
	}

}
