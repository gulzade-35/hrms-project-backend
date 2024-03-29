package javaproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaproject.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {

	Candidate findByNationalityId(String nationalityId);
	
	Candidate findByEmail(String email);
}
