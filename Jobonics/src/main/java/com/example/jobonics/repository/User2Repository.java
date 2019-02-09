package com.example.jobonics.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobonics.model.User2;

@Repository("user2Repository")
public interface User2Repository extends JpaRepository<User2, Long> {
    User2 findByEmail(String email);
}