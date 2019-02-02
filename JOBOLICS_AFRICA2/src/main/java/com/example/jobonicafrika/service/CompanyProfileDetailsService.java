package com.example.jobonicafrika.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobonicafrika.model.CompanyProfileDetails;
import com.example.jobonicafrika.repository.CompanyProfileDetailsRepository;
import com.example.jobonicafrika.repository.CreateProfileRepository;

@Service
public class CompanyProfileDetailsService {
	@Autowired
	CompanyProfileDetailsRepository CPR;
	
	/*to save an employee*/
	
	public CompanyProfileDetails save(CompanyProfileDetails std) {
		return CPR.save(std);
	}
	
	
	/* search all employees*/
	
	public List<CompanyProfileDetails> findAll(){
		return CPR.findAll();
	}
	
	
	/*get an employee by id*/
	public CompanyProfileDetails findOne(Integer id) {
		return CPR.findOne(id);
	}
	
	
	/*delete an employee*/
	
	public void delete(CompanyProfileDetails std) {
		CPR.delete(std);
	}
	

}
