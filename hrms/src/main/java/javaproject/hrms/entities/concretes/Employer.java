package javaproject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javaproject.hrms.entities.abstracts.User;
import lombok.Data;

@Data
@Entity
@Table(name="employers")
public class Employer extends User {

	
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="website_address")
	private String websiteAddress;
	
	@Column(name="company_mail")
	private String companyMail;
	
	@Column(name="phone_number")
	private String phoneNumber;
}
