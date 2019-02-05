package com.example.jobonics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobonics.model.NewJobs;

@Repository("newJobsRepository")
public interface NewJobsRepository extends JpaRepository<NewJobs, Integer> {

}
