package com.example.jobonics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobonics.model.CompanyAccount;
import com.example.jobonics.model.CompanyProfileDetails;
import com.example.jobonics.model.CreateProfile;

public interface CompanyAccountRepository extends JpaRepository<CompanyAccount, Integer> {

	CompanyAccount findOne(int id);

}
