package com.example.jobonics.model;

import java.sql.Blob;

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
@Table(name = "company_account")
@EntityListeners(AuditingEntityListener.class)
public class CompanyAccount {
	/*
	 * a. Company Name b. Phone Number c. Number of employees d. Company URL e.
	 * Organisation Type f. Primary Industry g. Logo h. Location i. Date established
	 * j. Headquarters k. Social Media
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "Company_Name")
	// @NotEmpty(message = "Please provide the Specialties")
	private String CompanyName;

	@Column(name = "PhoneNumber")
	private String PhoneNumber;

	@Column(name = "Number_of_employees")

	private String Number_of_employees;

	@Column(name = "CompanyURL")
	private String CompanyURL;

	@Column(name = "OrganisationType")

	private String OrganisationType;

	@Column(name = "PrimaryIndustry")
	// @NotEmpty(message = "Please provide the Vision")
	private String PrimaryIndustry;

	@Column(name = "Logo")
	// @NotEmpty(message = "Please provide your job Values")
	private byte[] Logo;

	@Column(name = "Location")
	// @NotEmpty(message = "Please provide Working with us")
	private String Location;

	@Column(name = "Date_established")
	// @NotEmpty(message = "Please provide Working with us")
	private String DateEstablished;

	@Column(name = "Headquarters")
	// @NotEmpty(message = "Please provide Working with us")
	private String Headquarters;

	@Column(name = "SocialMedia")
	// @NotEmpty(message = "Please provide Working with us")
	private String SocialMedia;

	public CompanyAccount() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getNumber_of_employees() {
		return Number_of_employees;
	}

	public void setNumber_of_employees(String number_of_employees) {
		Number_of_employees = number_of_employees;
	}

	public String getCompanyURL() {
		return CompanyURL;
	}

	public void setCompanyURL(String companyURL) {
		CompanyURL = companyURL;
	}

	public String getOrganisationType() {
		return OrganisationType;
	}

	public void setOrganisationType(String organisationType) {
		OrganisationType = organisationType;
	}

	public String getPrimaryIndustry() {
		return PrimaryIndustry;
	}

	public void setPrimaryIndustry(String primaryIndustry) {
		PrimaryIndustry = primaryIndustry;
	}

	
	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getDateEstablished() {
		return DateEstablished;
	}

	public void setDateEstablished(String dateEstablished) {
		DateEstablished = dateEstablished;
	}

	public String getHeadquarters() {
		return Headquarters;
	}

	public void setHeadquarters(String headquarters) {
		Headquarters = headquarters;
	}

	public String getSocialMedia() {
		return SocialMedia;
	}

	public void setSocialMedia(String socialMedia) {
		SocialMedia = socialMedia;
	}

	public CompanyAccount(int id, String companyName, String phoneNumber, String number_of_employees, String companyURL,
			String organisationType, String primaryIndustry,  String location, String dateEstablished,
			String headquarters, String socialMedia) {
		super();
		this.id = id;
		CompanyName = companyName;
		PhoneNumber = phoneNumber;
		Number_of_employees = number_of_employees;
		CompanyURL = companyURL;
		OrganisationType = organisationType;
		PrimaryIndustry = primaryIndustry;
		
		Location = location;
		DateEstablished = dateEstablished;
		Headquarters = headquarters;
		SocialMedia = socialMedia;
	}

	public CompanyAccount(byte[] logo) {
		super();
		Logo = logo;
	}

	public byte[] getLogo() {
		return Logo;
	}

	public void setLogo(byte[] logo) {
		Logo = logo;
	}

	
	
	
	
	
	
	
}
