package javaproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaproject.hrms.business.abstracts.EmployerService;
import javaproject.hrms.core.utilities.results.DataResult;
import javaproject.hrms.core.utilities.results.ErrorResult;
import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.core.utilities.results.SuccessDataResult;
import javaproject.hrms.core.utilities.results.SuccessResult;
import javaproject.hrms.dataAccess.abstracts.EmployerDao;
import javaproject.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public Result add(Employer employer) {
		if(!this.checkIfEmailExists(employer.getEmail())) {
			return new ErrorResult("E-posta zaten mevcut. ");
		}
		if(!this.validationForEmployer(employer)) {
			return new ErrorResult("Eksik bilgi.");
		}
		if(!this.checkIfEqualEmailAndDomain(employer.getEmail(),employer.getWebSite())) {
			return new ErrorResult("Geçersiz posta adresi.");
	}
		this.employerDao.save(employer);
		return new SuccessResult("Employer added !");
	}

	private boolean checkIfEqualEmailAndDomain(String email, String webSite) {
		String[] emailArr = email.split("@", 2);
		String domain = webSite.substring(4, webSite.length());

		if (emailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}

	private boolean validationForEmployer(Employer employer) {
		if(employer.getCompanyName() == null && employer.getWebSite()== null && employer.getEmail()== null
				&& employer.getPhoneNumber() == null && employer.getPassword() == null) {
			return false;
					
		}
		return true;
	}

	private boolean checkIfEmailExists(String email) {
		if(this.employerDao.findByEmail(email) !=null) {
			return false;
		}
		return true;
	}

	@Override
	public DataResult<Employer> getByEmail(String email) {

		return new SuccessDataResult<Employer>(this.employerDao.findByEmail(email));
	}

}
