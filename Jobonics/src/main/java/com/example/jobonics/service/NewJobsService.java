package com.example.jobonics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobonics.model.NewJobs;
import com.example.jobonics.repository.NewJobsRepository;

@Service("newJobsService")
public class NewJobsService {
	@Autowired
	NewJobsRepository newJobsRepository;
	
	/*to save an employee*/
	
	public NewJobs save(NewJobs newJobs) {
		return newJobsRepository.save(newJobs);
	}
	
	
	/* search all employees*/
	
	public List<NewJobs> findAll(){
		return newJobsRepository.findAll();
	}
	
	
	/*get an employee by id*/
	public NewJobs findOne(Integer id) {
		return newJobsRepository.findOne(id);
	}
	
	
	/*delete an employee*/
	
	public void delete(NewJobs newJobs) {
		newJobsRepository.delete(newJobs);
	}
	

}
