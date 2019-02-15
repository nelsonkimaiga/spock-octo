package com.example.jobonics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobonics.Persistence.model.CompanyProfileDetails;
import com.example.jobonics.Persistence.dao.CompanyProfileDetailsRepository;
import com.example.jobonics.Persistence.dao.CreateProfileRepository;

@Service
public class CompanyProfileDetailsService {
	@Autowired
	CompanyProfileDetailsRepository CPR;
	
	/*to save an company profile*/
	
	public CompanyProfileDetails save(CompanyProfileDetails std) {
		return CPR.save(std);
	}
	
	
	/* search all company profile*/
	
	public List<CompanyProfileDetails> findAll(){
		return CPR.findAll();
	}
	
	
	/*get an company profile by id*/
	public CompanyProfileDetails findOne(Integer id) {
		return CPR.findOne(id);
	}
	
	
	/*delete an company profile*/
	
	public void delete(CompanyProfileDetails std) {
		CPR.delete(std);
	}
	

}
