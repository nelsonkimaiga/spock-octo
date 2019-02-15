package com.example.jobonics.service;


import com.example.jobonics.Persistence.model.User;
import com.example.jobonics.Web.dto.UserDto;

public interface UserService {
    User findUserByEmail(String email);

    void createUserAccount(UserDto user);
}
