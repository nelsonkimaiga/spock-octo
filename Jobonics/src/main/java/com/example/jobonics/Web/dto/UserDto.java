package com.example.jobonics.Web.dto;


import com.example.jobonics.Validator.PasswordMatches;
import com.example.jobonics.Validator.ValidEmail;
import com.example.jobonics.Validator.ValidPassword;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@PasswordMatches
public class UserDto implements Serializable {
    @NotNull
    @NotEmpty(message = "*Please provide a Valid companyName")
    private String companyName;

    @NotNull
    @NotEmpty(message = "*Please provide a Valid fullName")
    private String fullName;

    @NotNull
    @NotEmpty(message = "*Please provide a valide countryName")
    private String country;

    @ValidPassword
    private String password;

    @NotNull
    @Size(min = 1)
    private String matchingPassword;

    @ValidEmail
    @NotNull
    @Size(min = 1)
    private String email;

    private boolean isUsing2FA;
    private Integer role;

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(final Integer role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(final String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(final String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public boolean isUsing2FA() {
        return isUsing2FA;
    }

    public void setUsing2FA(boolean isUsing2FA) {
        this.isUsing2FA = isUsing2FA;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("UserDto [fullName=").append(fullName)
        .append(", companyName=").append(companyName)
        .append(", countryName=").append(country)
        .append(", password=").append(password)
        .append(", matchingPassword=").append(matchingPassword)
        .append(", email=").append(email)
        .append(", isUsing2FA=").append(isUsing2FA)
        .append(", role=").append(role).append("]");
        return builder.toString();
    }

}
