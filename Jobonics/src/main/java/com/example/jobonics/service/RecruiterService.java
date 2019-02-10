package com.example.jobonics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobonics.model.Recruiter;
import com.example.jobonics.repository.RecruiterRepository;

@Service("recruiterService")
public class RecruiterService {

	private RecruiterRepository recruiterRepository;

	@Autowired
	public RecruiterService(RecruiterRepository recruiterRepository) {
		this.recruiterRepository = recruiterRepository;
	}
	
	public Recruiter findByEmail(String email) {
		return recruiterRepository.findByEmail(email);
	}
	
	public Recruiter findByConfirmationToken(String confirmationToken) {
		return recruiterRepository.findByConfirmationToken(confirmationToken);
	}
	
	public void saveRecruiter(Recruiter recruiter) {
		recruiterRepository.save(recruiter);
	}

}