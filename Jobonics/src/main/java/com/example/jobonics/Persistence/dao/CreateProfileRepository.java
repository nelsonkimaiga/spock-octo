package com.example.jobonics.Persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobonics.Persistence.model.CreateProfile;

public interface CreateProfileRepository extends JpaRepository<CreateProfile, Integer> {

}
