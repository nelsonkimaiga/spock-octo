package com.example.jobonics.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobonics.model.UserRecruiter;

@Repository("userRecruiterRepository")
public interface UserRecruiterRepository extends JpaRepository<UserRecruiter, Long> {
    UserRecruiter findByEmail(String email);
}