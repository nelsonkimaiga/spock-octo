package com.example.jobonicafrika.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Entity
@Table(name = "newjobs")
@EntityListeners(AuditingEntityListener.class)
public class NewJobs {
	/*
	 * 10. New Job a. Job Title b. Job Summary c. Job description d. Share job on
	 * free boards e. Share job on social media f. Location g. Industry h.
	 * Profession i. Job type j. Career level k. Min years of experience l. Min
	 * qualification m. Salary n. Application deadline
	 * 
	 * ///advise if this requires to be in this "new job"db table o. Save draft p.
	 * Post job q. Cancel r. Success true or false
	 */

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "JobTitle")
	@NotEmpty(message = "Please provide the job title")
	private String jobTitle;

	@Column(name = "job_summary")
	private String jobSummary;

	@Column(name = "job_description")

	private String jobDescription;

	@Column(name = "location")
	private String Location;

	@Column(name = "industry")

	private String industry;

	@Column(name = "profession")
	@NotEmpty(message = "Please provide the profession")
	private String profession;

	@Column(name = "jobtype")
	@NotEmpty(message = "Please provide your job type")
	private String jobType;

	@Column(name = "career_level")
	@NotEmpty(message = "Please provide career level required")
	private String careerLevel;

	@Column(name = "min_experience")
	@NotEmpty(message = "Please provide the Min years of experience")
	private String minExperience;

	@Column(name = "min_qualification")
	@NotEmpty(message = "Please provide the Min Qualifications")
	private String minQualification;

	@Column(name = "salary")
	@NotEmpty(message = "Please provide the salary")
	private String salary;

	@Column(name = "deadline_date")
	@NotEmpty(message = "Please provide the Applications Deadline")
	private String deadlineDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobSummary() {
		return jobSummary;
	}

	public void setJobSummary(String jobSummary) {
		this.jobSummary = jobSummary;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}


	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getCareerLevel() {
		return careerLevel;
	}

	public void setCareerLevel(String careerLevel) {
		this.careerLevel = careerLevel;
	}

	public String getMinExperience() {
		return minExperience;
	}

	public void setMinExperience(String minExperience) {
		this.minExperience = minExperience;
	}

	public String getMinQualification() {
		return minQualification;
	}

	public void setMinQualification(String minQualification) {
		this.minQualification = minQualification;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDeadlineDate() {
		return deadlineDate;
	}

	public void setDeadlineDate(String deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	public NewJobs(int id, String jobTitle, String jobSummary, String jobDescription, String location, String industry,
			String profession, String jobType, String careerLevel, String minExperience, String minQualification,
			String salary, String deadlineDate) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
		this.jobSummary = jobSummary;
		this.jobDescription = jobDescription;
		Location = location;
		this.industry = industry;
		this.profession = profession;
		this.jobType = jobType;
		this.careerLevel = careerLevel;
		this.minExperience = minExperience;
		this.minQualification = minQualification;
		this.salary = salary;
		this.deadlineDate = deadlineDate;
	}

	public NewJobs() {
		// TODO Auto-generated constructor stub
	}
	

}

