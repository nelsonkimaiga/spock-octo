package com.example.jobonics.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public abstract class WebMvcConfig implements WebMvcConfigurer {
 
 @Bean
 public BCryptPasswordEncoder passwordEncoder() {
  BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
  return bCryptPasswordEncoder;
 }


}