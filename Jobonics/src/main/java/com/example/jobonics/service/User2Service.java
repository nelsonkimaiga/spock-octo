package com.example.jobonics.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jobonics.model.Role2;
import com.example.jobonics.model.User2;
import com.example.jobonics.repository.Role2Repository;
import com.example.jobonics.repository.User2Repository;

import java.util.Arrays;
import java.util.HashSet;

@Service("user2Service")
public class User2Service {

    private User2Repository userRepository;
    private Role2Repository role2Repository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public User2Service(User2Repository userRepository,
                       Role2Repository role2Repository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.role2Repository = role2Repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User2 findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User2 saveUser(User2 user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role2 userRole = role2Repository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role2>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

}