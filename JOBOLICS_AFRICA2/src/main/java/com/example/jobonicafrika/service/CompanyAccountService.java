package com.example.jobonicafrika.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobonicafrika.model.CompanyAccount;
import com.example.jobonicafrika.repository.CompanyAccountRepository;
import com.example.jobonicafrika.repository.CompanyProfileDetailsRepository;
import com.example.jobonicafrika.repository.CreateProfileRepository;

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
