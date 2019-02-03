package com.example.jobonics.service;

import com.example.jobonics.model.User;

public interface UserService {
  
 public User findUserByEmail(String email);
 
 public void saveUser(User user);
}