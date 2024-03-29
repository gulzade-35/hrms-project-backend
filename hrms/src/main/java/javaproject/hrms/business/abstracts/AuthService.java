package javaproject.hrms.business.abstracts;

import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.entities.concretes.Candidate;
import javaproject.hrms.entities.concretes.Employer;

public interface AuthService {

	   Result registerEmployer(Employer employer, String confirmedPassword);
	   
	   Result registerCandidate(Candidate candidate, String confirmedPassword);
	   
	   Result verifyEmail(int user_id, String activationCode);
}
