package javaproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaproject.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	JobAdvertisement getById(int JobId);
}
