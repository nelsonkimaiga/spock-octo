package com.example.jobonicafrika.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobonicafrika.model.NewJobs;

public interface NewJobsRepository extends JpaRepository<NewJobs, Integer> {

}
