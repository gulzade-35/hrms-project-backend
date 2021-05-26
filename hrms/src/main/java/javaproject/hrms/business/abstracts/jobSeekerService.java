package javaproject.hrms.business.abstracts;

import java.util.List;

import javaproject.hrms.entities.concretes.JobSeeker;

public interface jobSeekerService {
	List<JobSeeker> getAll();
	
}
