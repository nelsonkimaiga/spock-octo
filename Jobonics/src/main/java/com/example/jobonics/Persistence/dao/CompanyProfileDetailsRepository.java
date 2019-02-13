package com.example.jobonics.Persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobonics.Persistence.model.CompanyProfileDetails;
import com.example.jobonics.Persistence.model.CreateProfile;

public interface CompanyProfileDetailsRepository extends JpaRepository<CompanyProfileDetails, Integer> {

}
