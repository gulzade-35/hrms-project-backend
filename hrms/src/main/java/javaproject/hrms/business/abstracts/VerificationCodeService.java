package javaproject.hrms.business.abstracts;

import javaproject.hrms.core.utilities.results.DataResult;
import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {

	Result add(VerificationCode code);
	
	DataResult<VerificationCode> getByUserIdAndVerificationCode(int userId, String verificationCode);
	
	Result update(VerificationCode code);
}
