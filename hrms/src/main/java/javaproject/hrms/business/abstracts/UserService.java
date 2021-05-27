package javaproject.hrms.business.abstracts;

import java.util.List;

import javaproject.hrms.entities.abstracts.User;

public interface UserService {
	List<User> getAll();
}
