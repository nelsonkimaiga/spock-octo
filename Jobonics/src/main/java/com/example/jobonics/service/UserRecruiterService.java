package com.example.jobonics.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jobonics.model.RoleRecruiter;
import com.example.jobonics.model.UserRecruiter;
import com.example.jobonics.repository.RoleRecruiterRepository;
import com.example.jobonics.repository.UserRecruiterRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service("user2Service")
public class UserRecruiterService {

    private UserRecruiterRepository userRepository;
    private RoleRecruiterRepository roleRecruiterRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserRecruiterService(UserRecruiterRepository userRepository,
                       RoleRecruiterRepository roleRecruiterRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRecruiterRepository = roleRecruiterRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserRecruiter findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserRecruiter saveUser(UserRecruiter user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        RoleRecruiter userRole = roleRecruiterRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<RoleRecruiter>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

}