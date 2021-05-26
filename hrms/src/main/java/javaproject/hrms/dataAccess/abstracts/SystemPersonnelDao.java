package javaproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaproject.hrms.entities.concretes.SystemPersonnel;

public interface SystemPersonnelDao extends JpaRepository<SystemPersonnel,Integer> {

}
