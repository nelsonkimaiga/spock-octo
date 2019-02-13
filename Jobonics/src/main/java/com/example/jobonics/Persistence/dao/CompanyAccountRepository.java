package com.example.jobonics.Persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobonics.Persistence.model.CompanyAccount;
import com.example.jobonics.Persistence.model.CompanyProfileDetails;
import com.example.jobonics.Persistence.model.CreateProfile;

public interface CompanyAccountRepository extends JpaRepository<CompanyAccount, Integer> {

	CompanyAccount findOne(int id);

}
