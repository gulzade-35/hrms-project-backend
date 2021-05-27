package javaproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaproject.hrms.entities.abstracts.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
