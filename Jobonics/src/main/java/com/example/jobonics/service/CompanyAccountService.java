package com.example.jobonics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobonics.model.CompanyAccount;
import com.example.jobonics.repository.CompanyAccountRepository;
import com.example.jobonics.repository.CompanyProfileDetailsRepository;
import com.example.jobonics.repository.CreateProfileRepository;

@Service
public class CompanyAccountService {
	@Autowired
	CompanyAccountRepository CAR;
	
	/*to save an employee*/
	
	public CompanyAccount save(CompanyAccount std) {
		return CAR.save(std);
	}
	
	
	/* search all employees*/
	
	public List<CompanyAccount> findAll(){
		return CAR.findAll();
	}
	
	
	/*get an employee by id*/
	public CompanyAccount findOne(Integer id) {
		return CAR.findOne(id);
	}
	
	
	/*delete an employee*/
	
	public void delete(CompanyAccount std) {
		CAR.delete(std);
	}
	

}
