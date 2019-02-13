package com.example.jobonics.Persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobonics.Persistence.model.NewJobs;

@Repository("newJobsRepository")
public interface NewJobsRepository extends JpaRepository<NewJobs, Integer> {
	
	
}
