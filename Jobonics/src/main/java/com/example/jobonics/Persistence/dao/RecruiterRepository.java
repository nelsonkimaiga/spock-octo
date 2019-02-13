package com.example.jobonics.Persistence.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.jobonics.Persistence.model.Recruiter;

@Repository("recruiterRepository")
public interface RecruiterRepository extends CrudRepository<Recruiter, Long>{
    Recruiter findByEmail(String email);
    Recruiter findByConfirmationToken(String confirmationToken);
}