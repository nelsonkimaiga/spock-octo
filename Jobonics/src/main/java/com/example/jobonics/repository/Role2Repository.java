package com.example.jobonics.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobonics.model.Role2;

@Repository("role2Repository")
public interface Role2Repository extends JpaRepository<Role2, Integer> {
    Role2 findByRole(String role);

}
