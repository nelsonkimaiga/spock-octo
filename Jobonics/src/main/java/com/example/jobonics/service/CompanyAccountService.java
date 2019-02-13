package com.example.jobonics.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobonics.Persistence.model.CompanyAccount;
import com.example.jobonics.Persistence.dao.CompanyAccountRepository;
import com.example.jobonics.Persistence.dao.CompanyProfileDetailsRepository;
import com.example.jobonics.Persistence.dao.CreateProfileRepository;

@Service
public class CompanyAccountService {
	@Autowired
	CompanyAccountRepository CAR;
	
	/*to save an company account*/
	
	public CompanyAccount save(CompanyAccount std) {
		return CAR.save(std);
	}
	
	
	/* search all company account*/
	
	public List<CompanyAccount> findAll(){
		return CAR.findAll();
	}
	
	
	/*get an company account by id*/
	public CompanyAccount findOne(Integer id) {
		return CAR.findOne(id);
	}
	
	
	/*delete an company account*/
	
	public void delete(CompanyAccount std) {
		CAR.delete(std);
	}
	

}
