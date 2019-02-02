package com.example.jobonics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobonics.model.CompanyProfileDetails;
import com.example.jobonics.model.CreateProfile;

public interface CompanyProfileDetailsRepository extends JpaRepository<CompanyProfileDetails, Integer> {

}
