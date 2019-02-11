package com.example.jobonics.service;

import com.example.jobonics.model.UserRecruiter;
import com.example.jobonics.Dto.UserDto;

public interface UserRecruiterService {
    UserRecruiter findUserByEmail(String email);
    void createUserAccount(UserDto user);
}