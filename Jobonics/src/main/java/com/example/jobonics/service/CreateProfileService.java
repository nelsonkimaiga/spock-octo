package com.example.jobonics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobonics.model.CreateProfile;
import com.example.jobonics.repository.CreateProfileRepository;

@Service
public class CreateProfileService {
	@Autowired
	CreateProfileRepository CPR;
	
	/*to save an cps*/
	
	public CreateProfile save(CreateProfile std) {
		return CPR.save(std);
	}
	
	
	/* search all cps*/
	
	public List<CreateProfile> findAll(){
		return CPR.findAll();
	}
	
	
	/*get an cps by id*/
	public CreateProfile findOne(Integer id) {
		return CPR.findOne(id);
	}
	
	
	/*delete an cps*/
	
	public void delete(CreateProfile std) {
		CPR.delete(std);
	}
	

}
