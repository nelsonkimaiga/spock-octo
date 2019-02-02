package com.example.jobonicafrika.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "hustlers_profile")
public class CreateProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "full_name")
	//@NotEmpty(message = "Please provide your full names")
	private String fullname;

	@Column(name = "profpic")
	
	private byte[] profPic;

	@Column(name = "Aboutme")
	//@NotEmpty(message = "Please provide deatils about you")
	private String aboutMe;

	@Column(name = "current_Position")
	//@NotEmpty(message = "Please provide your Current Position and Company")
	private String currentPosition;

	@Column(name = "work_experience")
	//@NotEmpty(message = "Please provide your work experience")
	private String workExperience;

	@Column(name = "education")
	//@NotEmpty(message = "Please provide your Academics Details")
	private String education;

	@Column(name = "contacts")
	//@NotEmpty(message = "Please provide your Contact")
	private String contacts;

	@Column(name = "skills")
	//@NotEmpty(message = "Please provide your skills")
	private String skills;

	@Column(name = "intrests")
	//@NotEmpty(message = "Please provide your full names")
	private String intrests;

	@Column(name = "reviews")
	//@NotEmpty(message = "Please provide your reviews")
	private String reviews;

	@Column(name = "awards")
	private String awards;

	@Column(name = "languages")
	private String languages;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	
	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(String currentPosition) {
		this.currentPosition = currentPosition;
	}

	public String getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getIntrests() {
		return intrests;
	}

	public void setIntrests(String intrests) {
		this.intrests = intrests;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public CreateProfile(int id, String fullName,  String aboutMe, String currentPosition,
			String workExperience, String education, String contacts, String skills, String intrests, String reviews,
			String awards, String languages) {
		super();
		this.id = id;
		this.fullname = fullName;
		
		this.aboutMe = aboutMe;
		this.currentPosition = currentPosition;
		this.workExperience = workExperience;
		this.education = education;
		this.contacts = contacts;
		this.skills = skills;
		this.intrests = intrests;
		this.reviews = reviews;
		this.awards = awards;
		this.languages = languages;
	}

	public byte[] getProfPic() {
		return profPic;
	}

	public void setProfPic(byte[] profPic) {
		this.profPic = profPic;
	}

	public CreateProfile() {
		// TODO Auto-generated constructor stub
	}

	
}
