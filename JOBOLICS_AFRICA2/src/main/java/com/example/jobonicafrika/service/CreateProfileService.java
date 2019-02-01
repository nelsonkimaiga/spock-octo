package com.example.jobonicafrika.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobonicafrika.model.CreateProfile;
import com.example.jobonicafrika.repository.CreateProfileRepository;

@Service
public class CreateProfileService {
	@Autowired
	CreateProfileRepository CPR;
	
	/*to save an employee*/
	
	public CreateProfile save(CreateProfile std) {
		return CPR.save(std);
	}
	
	
	/* search all employees*/
	
	public List<CreateProfile> findAll(){
		return CPR.findAll();
	}
	
	
	/*get an employee by id*/
	public CreateProfile findOne(Integer id) {
		return CPR.findOne(id);
	}
	
	
	/*delete an employee*/
	
	public void delete(CreateProfile std) {
		CPR.delete(std);
	}
	

}
