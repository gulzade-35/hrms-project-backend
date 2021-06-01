package javaproject.hrms.business.concretes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaproject.hrms.business.abstracts.AuthService;
import javaproject.hrms.business.abstracts.CandidateService;
import javaproject.hrms.business.abstracts.EmployerService;
import javaproject.hrms.business.abstracts.VerificationCodeService;


import javaproject.hrms.core.utilities.results.ErrorResult;
import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.core.utilities.results.SuccessResult;
import javaproject.hrms.core.utilities.verification.VerificationService;
import javaproject.hrms.entities.concretes.Candidate;
import javaproject.hrms.entities.concretes.Employer;
import javaproject.hrms.entities.concretes.VerificationCode;

@Service
public class AuthManager implements AuthService {

	private CandidateService candidateService;
	private EmployerService employerService;
	private VerificationCodeService codeService;
	private VerificationService verificationService;
	
	@Autowired
	public AuthManager(CandidateService candidateService, EmployerService employerService,
			VerificationCodeService codeService, VerificationService verificationService) {
		super();
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.codeService = codeService;
		this.verificationService = verificationService;
	}
	
	//Bu kısımları esra sancaktan baktım. Araştırıp yaptım.

	@Override
	public Result registerEmployer(Employer employer, String confirmedPassword) {
		if(!checkIfEqualsPasswordAndConfirmPassword(employer.getPassword(),confirmedPassword)) {
			
			return new ErrorResult("Parolalar uyuşmuyor!");
		}
		
		var result = this.employerService.add(employer);
		
		if(result.isSuccess()) {
			String code = this.verificationService.codeGenerator();
				this.verificationService.sendVerificationCode(code);
				
				VerificationCode umut = new VerificationCode(employer.getId(),code,LocalDate.now().plusDays(1));
				this.codeService.add(umut);
				
				return new SuccessResult("İş veren kayıtlı");
		}
		
		return new ErrorResult("Bir terslik oldu. Tekrar deneyiniz.");
	}

	private boolean checkIfEqualsPasswordAndConfirmPassword(String password, String confirmedPassword) {
		if(!password.equals(confirmedPassword)) {
			return false;
		}
		return true;
	}

	@Override
	public Result registerCandidate(Candidate candidate, String confirmedPassword) {
		if(!checkIfEqualsPasswordAndConfirmPassword(candidate.getPassword(), confirmedPassword)) {
			 return new ErrorResult("Parolalar uyuşmuyor.!");
		}
		
		var result = this.candidateService.add(candidate);
		
		if(result.isSuccess()) {
			
			String code = this.verificationService.codeGenerator();
            this.verificationService.sendVerificationCode(code);  
			
			VerificationCode umut = new VerificationCode(candidate.getId(),code,LocalDate.now().plusDays(1));
			this.codeService.add(umut);
			
			return new SuccessResult("Aday kayıtlı");
		}
		return new ErrorResult("Bir terslik oldu. Tekrar deneyiniz.");
	}

	@Override
	public Result verifyEmail(int user_id, String activationCode) {

		var result = this.codeService.getByUserIdAndVerificationCode(user_id, activationCode);
		
	    if(result.getData() ==null) {
	    	
	    	return new ErrorResult("Verification Code is wrong !");
	    }
	    
	    if(result.getData().getIsActivate()) {
	    	return new ErrorResult("Verification Code is already active");
	    }
	    
	    if(result.getData().getExpiredDate().isBefore(LocalDate.now())){
	 
	    	return new ErrorResult("Verification Code is Expired");
	    }
	    
        VerificationCode verificationCode = result.getData();
	    
	    verificationCode.setConfirmedDate(LocalDate.now());
	    verificationCode.setIsActivate(true);
	    this.codeService.update(verificationCode);
	    
		return new SuccessResult("Doğrulandı.");
	   
	}

}
