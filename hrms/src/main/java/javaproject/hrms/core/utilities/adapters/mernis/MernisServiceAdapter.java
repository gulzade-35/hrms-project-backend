package javaproject.hrms.core.utilities.adapters.mernis;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import javaproject.hrms.mernisService.FakeMernisService;

@Service
public class MernisServiceAdapter implements UserCheckService {

	@Override
	public boolean checkIfRealPerson(long nationalityId, String firstName, String lastName, LocalDate dateOfBirth) {
		
		FakeMernisService client = new FakeMernisService();		
		
		boolean result =client .TCKimlikNoDogrula(nationalityId, firstName, lastName, dateOfBirth);
		
		return result;
	}

}
