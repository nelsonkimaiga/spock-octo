package com.example.jobonics.service;

import com.example.jobonics.repository.UserRecruiterRepository;
import com.example.jobonics.repository.RoleRecruiterRepository;
import com.example.jobonics.model.UserRecruiter;
import com.example.jobonics.model.RoleRecruiter;
import com.example.jobonics.service.UserRecruiterService;
import com.example.jobonics.Dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashSet;

@Service("userRecruiterService")
public class UserRecruiterServiceImpl implements UserRecruiterService{
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRecruiterRepository userRecruiterRepository;
    @Autowired
    private RoleRecruiterRepository roleRecruiterRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private LoginAttemptService loginAttemptService;

    @Autowired
    private HttpServletRequest request;

    @Override
    public UserRecruiter findUserByEmail(String email) {
        String ip = getClientIP();
        if (loginAttemptService.isBlocked(ip)) {
            throw new RuntimeException("blocked");
        }
        return userRecruiterRepository.findByEmail(email);
    }

    @Override
    public void createUserAccount(UserDto accountDto) {
        final UserRecruiter user = new UserRecruiter();
        user.setCompanyName(accountDto.getCompanyName());
        user.setFullName(accountDto.getFullName());
        user.setCountryName(accountDto.getCountryName());
        user.setEmail(accountDto.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(accountDto.getPassword()));
        user.setActive(1);
        RoleRecruiter userRole = roleRecruiterRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<RoleRecruiter>(Arrays.asList(userRole)));
        userRecruiterRepository.save(user);
    }
    private String getClientIP() {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
}