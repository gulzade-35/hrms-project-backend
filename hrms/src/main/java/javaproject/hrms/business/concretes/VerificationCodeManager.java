package javaproject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaproject.hrms.business.abstracts.VerificationCodeService;
import javaproject.hrms.core.utilities.results.DataResult;
import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.core.utilities.results.SuccessDataResult;
import javaproject.hrms.core.utilities.results.SuccessResult;
import javaproject.hrms.dataAccess.abstracts.VerificationCodeDao;
import javaproject.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {

	private VerificationCodeDao verificationCodeDao;
	
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public Result add(VerificationCode code) {
		this.verificationCodeDao.save(code);
		return new SuccessResult("Kod eklendi !");
	}

	@Override
	public DataResult<VerificationCode> getByUserIdAndVerificationCode(int userId, String verificationCode) {
		return new SuccessDataResult<VerificationCode>(this.verificationCodeDao.findByUserIdAndVerificationCode(userId, verificationCode));
	}

	@Override
	public Result update(VerificationCode code) {
		this.verificationCodeDao.save(code);
		return new SuccessResult("Kod güncellendi !");
	}

}
