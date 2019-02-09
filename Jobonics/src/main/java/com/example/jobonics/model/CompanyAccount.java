package com.example.jobonics.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "company_account")
@EntityListeners(AuditingEntityListener.class)

@SecondaryTable(name = "company_profile")
public class CompanyAccount {
	private int id;
	private String CompanyName;
	private String PhoneNumber;
	private String Number_of_employees;
	private String CompanyURL;
	private String OrganisationType;
	private String PrimaryIndustry;
	private byte[] Logo;
	private String Location;
	private String DateEstablished;
	private String Headquarters;
	private String SocialMedia;
	

	
	public CompanyAccount() {
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company_account")
	private List<NewJobs> jobs = new ArrayList<NewJobs>();

	
	@Id
	// @org.hibernate.annotations.ColumnDefault("001")
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public byte[] getLogo() {
		return Logo;
	}

	public void setLogo(byte[] logo) {
		Logo = logo;
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
			String organisationType, String primaryIndustry, byte[] logo, String location, String dateEstablished,
			String headquarters, String socialMedia) {
		super();
		this.id = id;
		CompanyName = companyName;
		PhoneNumber = phoneNumber;
		Number_of_employees = number_of_employees;
		CompanyURL = companyURL;
		OrganisationType = organisationType;
		PrimaryIndustry = primaryIndustry;
		Logo = logo;
		Location = location;
		DateEstablished = dateEstablished;
		Headquarters = headquarters;
		SocialMedia = socialMedia;

	}


}
