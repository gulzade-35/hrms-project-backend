package javaproject.hrms.business.abstracts;

import java.util.List;

import javaproject.hrms.entities.concretes.SystemPersonnel;

public interface SystemPersonnelService {
	List<SystemPersonnel> getAll();
}
