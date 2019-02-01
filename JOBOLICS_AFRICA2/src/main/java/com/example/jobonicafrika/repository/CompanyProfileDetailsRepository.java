package com.example.jobonicafrika.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobonicafrika.model.CompanyProfileDetails;
import com.example.jobonicafrika.model.CreateProfile;

public interface CompanyProfileDetailsRepository extends JpaRepository<CompanyProfileDetails, Integer> {

}
