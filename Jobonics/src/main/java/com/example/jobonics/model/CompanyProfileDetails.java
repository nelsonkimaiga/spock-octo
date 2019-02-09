package com.example.jobonics.model;

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
@Table(name = "company_profile")
@EntityListeners(AuditingEntityListener.class)
public class CompanyProfileDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "Specialties")
	 @NotEmpty(message = "Please provide the Specialties")
	private String Specialties;

	@Column(name = "Aboutus")
	private String Aboutus;

	@Column(name = "Benefits")

	private String Benefits;

	@Column(name = "Awards")
	private String Awards;

	@Column(name = "kompanyMission")

	private String Mission;

	@Column(name = "kompanyVision")
	@NotEmpty(message = "Please provide the Vision")
	private String Vision;

	@Column(name = "kompanyValues")
	@NotEmpty(message = "Please provide your job Values")
	private String Values;

	@Column(name = "WorkWithus")
	@NotEmpty(message = "Please provide Working with us")
	private String Workingwithus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpecialties() {
		return Specialties;
	}

	public void setSpecialties(String specialties) {
		Specialties = specialties;
	}

	public String getAboutus() {
		return Aboutus;
	}

	public void setAboutus(String aboutus) {
		Aboutus = aboutus;
	}

	public String getBenefits() {
		return Benefits;
	}

	public void setBenefits(String benefits) {
		Benefits = benefits;
	}

	public String getAwards() {
		return Awards;
	}

	public void setAwards(String awards) {
		Awards = awards;
	}

	public String getMission() {
		return Mission;
	}

	public void setMission(String mission) {
		Mission = mission;
	}

	public String getVision() {
		return Vision;
	}

	public void setVision(String vision) {
		Vision = vision;
	}

	public String getValues() {
		return Values;
	}

	public void setValues(String values) {
		Values = values;
	}

	public String getWorkingwithus() {
		return Workingwithus;
	}

	public void setWorkingwithus(String workingwithus) {
		Workingwithus = workingwithus;
	}

	
	public CompanyProfileDetails(int id, String specialties, String aboutus, String benefits, String awards,
			String mission, String vision, String values, String workingwithus) {
		super();
		this.id = id;
		Specialties = specialties;
		Aboutus = aboutus;
		Benefits = benefits;
		Awards = awards;
		Mission = mission;
		Vision = vision;
		Values = values;
		Workingwithus = workingwithus;
	}

	public CompanyProfileDetails() {
		// TODO Auto-generated constructor stub
	}

}
