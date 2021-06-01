package javaproject.hrms.business.abstracts;

import java.util.List;

import javaproject.hrms.core.utilities.results.DataResult;
import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.entities.concretes.Candidate;

public interface CandidateService {

	DataResult<Candidate> getByNationalId(String nationalId);
	
	DataResult<Candidate> getByEmail(String email);
	
	Result add(Candidate candidate);
	
	DataResult<List<Candidate>> getAll();
}
