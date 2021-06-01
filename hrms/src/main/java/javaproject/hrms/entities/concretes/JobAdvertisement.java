package javaproject.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_advertisement")
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="open_position_count")
	private int openPositionCount;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="appeal_deadline")
	private LocalDate appealDeadline;
	
	@Column(name="created_date")
	private LocalDate createdDate= LocalDate.now();
	
	@Column(name="is_active")
	private Boolean isActive = true;
	
	@Column(name="is_deleted")
	private Boolean isDeleted= false;
	
	@Column(name="is_opened")
	private Boolean isOpened = false;
	
	
	
	
}
