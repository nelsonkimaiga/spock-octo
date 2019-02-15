package com.example.jobonics.Persistence.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "newjobs")
@EntityListeners(AuditingEntityListener.class)
public class NewJobs {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@org.hibernate.annotations.ColumnDefault("001")
	private int newjobid;

	public NewJobs() {
	}

	@Column(name = "Employer")
	//@NotEmpty(message = "Please provide the job title")
	private String Employer;
	
	
	@Column(name = "JobTitle")
	@NotEmpty(message = "Please provide the job title")
	private String jobTitle;

	@Column(name = "job_summary", length = 1000)
	private String jobSummary;

	@Column(name = "job_description", length = 1000)
	private String jobDescription;

	@Column(name = "location")
	private String Location;

	@Column(name = "career_level")
	@NotEmpty(message = "Please provide career level required")
	private String careerLevel;

	public String getCareerLevel() {
		return careerLevel;
	}

	public void setCareerLevel(String careerLevel) {
		this.careerLevel = careerLevel;
	}

	@Column(name = "industry")

	private String industry;

	@Column(name = "profession")
	@NotEmpty(message = "Please provide the profession")
	private String profession;

	@Column(name = "jobtype")
	@NotEmpty(message = "Please provide your job type")

	private String jobType;
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

	@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, nullable = false)
	private Date created_at;

	public long getNewjobid() {
		return newjobid;
	}

	public void setNewjobid(int newjobid) {
		this.newjobid = newjobid;
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

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public NewJobs(int newjobid, String jobTitle, String jobSummary, String jobDescription, String location,
			String careerLevel, String industry, String profession, String jobType, String minExperience,
			String minQualification, String salary, String deadlineDate, Date created_at) {
		super();
		this.newjobid = (int) newjobid;
		this.jobTitle = jobTitle;
		this.jobSummary = jobSummary;
		this.jobDescription = jobDescription;
		Location = location;
		this.careerLevel = careerLevel;
		this.industry = industry;
		this.profession = profession;
		this.jobType = jobType;
		this.minExperience = minExperience;
		this.minQualification = minQualification;
		this.salary = salary;
		this.deadlineDate = deadlineDate;
		this.created_at = created_at;

	}

	@ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "company_account")
	@JoinTable(name = "company_jobs", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "newjobid") })
	private CompanyAccount CompanyAccount;

}
