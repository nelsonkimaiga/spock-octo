package com.example.jobonics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobonics.model.NewJobs;

public interface NewJobsRepository extends JpaRepository<NewJobs, Integer> {

}
