package javaproject.hrms.business.concretes;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaproject.hrms.business.abstracts.CandidateService;
import javaproject.hrms.core.utilities.adapters.mernis.UserCheckService;
import javaproject.hrms.core.utilities.results.DataResult;
import javaproject.hrms.core.utilities.results.ErrorResult;
import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.core.utilities.results.SuccessDataResult;
import javaproject.hrms.core.utilities.results.SuccessResult;
import javaproject.hrms.dataAccess.abstracts.CandidateDao;
import javaproject.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	
	private CandidateDao candidateDao;
	private UserCheckService userCheckService;
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserCheckService userCheckService) {
		super();
		this.candidateDao = candidateDao;
		this.userCheckService = userCheckService;
	}

	@Override
	public DataResult<Candidate> getByNationalId(String nationalId) {
		
		return new SuccessDataResult<Candidate>(this.candidateDao.findByNationalityId(nationalId));
	}

	@Override
	public DataResult<Candidate> getByEmail(String email) {
		
		return new SuccessDataResult<Candidate>(this.candidateDao.findByEmail(email));
	}

	@Override
	public Result add(Candidate candidate) {
		
		if(!validationForCandidate(candidate)) {
			return new ErrorResult("Eksik bilgi.");
		}
		
		if(!checkIfRealPerson(candidate)) {
			return new ErrorResult("Geçersiz kişi.");
		}
		
		if(!cechkIfEmailExists(candidate.getEmail())) {
			return new ErrorResult("E-posta mevcut.");
		}
		
		if(!checkIfNationalityId(candidate.getNationalityId())) {
			return new ErrorResult("Kimlik no mevcut.");
		}
		
		this.candidateDao.save(candidate);
		return new SuccessResult("Aday eklendi.");
	}

	private boolean checkIfNationalityId(String nationalityId) {
		
		if(this.candidateDao.findByNationalityId(nationalityId)!=null) {
			return false;
		}
		return true;
	}

	private boolean cechkIfEmailExists(String email) {
		if(this.candidateDao.findByNationalityId(email)!=null) {
			return false;
		}
		return true;
	}

	private boolean checkIfRealPerson(Candidate candidate) {
		if(!this.userCheckService.checkIfRealPerson(Long.parseLong(candidate.getNationalityId()), candidate.getFirstName().toUpperCase(new Locale("tr")), candidate.getLastName().toLowerCase(new Locale("tr")),
				   candidate.getDateOfBirth())) {
			   
			   return false;
		   }
		   return true;
	}

	private boolean validationForCandidate(Candidate candidate) {
		if(candidate.getFirstName() == null && candidate.getLastName() == null && candidate.getNationalityId() == null
				&& candidate.getDateOfBirth() == null && candidate.getEmail() == null) {
			return false;
					
		}
		return true;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}

	
}
