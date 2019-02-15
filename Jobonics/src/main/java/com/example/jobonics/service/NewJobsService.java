package com.example.jobonics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobonics.Persistence.model.NewJobs;
import com.example.jobonics.Persistence.dao.NewJobsRepository;

@Service("newJobsService")
public class NewJobsService {
	@Autowired
	NewJobsRepository newJobsRepository;
	
	/*to save an jobs*/
	
	public NewJobs save(NewJobs newJobs) {
		return newJobsRepository.save(newJobs);
	}
	
	
	/* search all jobs*/
	
	public List<NewJobs> findAll(){
		return newJobsRepository.findAll();
	}
	
	
	/*get an jobs by id*/
	public NewJobs findOne(Integer newjobid) {
		return newJobsRepository.findOne(newjobid);
	}
	
	/*delete an jobs*/
	
	public void delete(NewJobs newJobs) {
		newJobsRepository.delete(newJobs);
	}
	
	/*searching the jobs and displaying with company details*/
	
	
	

}
