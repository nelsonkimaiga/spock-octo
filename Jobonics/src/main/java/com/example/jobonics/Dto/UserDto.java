package com.example.jobonics.Dto;

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
    @NotEmpty(message = "*Please provide a Valid FullName")
    private String fullName;

    @NotNull
    @NotEmpty(message = "*Please provide a Valid CompanyName")
    private String companyName;

    @NotNull
    @NotEmpty(message = "*Please provide a Valid countryName")
    private String countryName;

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


    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(final String companyName) {
        this.companyName = companyName;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(final String countryName) {
        this.countryName = countryName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return this.matchingPassword;
    }

    public void setMatchingPassword(final String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public boolean isIsUsing2FA() {
        return this.isUsing2FA;
    }

    public boolean getIsUsing2FA() {
        return this.isUsing2FA;
    }

    public void setIsUsing2FA(boolean isUsing2FA) {
        this.isUsing2FA = isUsing2FA;
    }

    public Integer getRole() {
        return this.role;
    }

    public void setRole(final Integer role) {
        this.role = role;
    }
    
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("UserDto [fullName=").append(fullName).
        append(", companyName=").append(companyName).
        append(", countryName=").append(countryName).
        append(", password=").append(password).
        append(", matchingPassword=").append(matchingPassword).
        append(", email=").append(email).
        append(", isUsing2FA=").append(isUsing2FA).
        append(", role=").append(role).
        append("]");
        return builder.toString();
    }    

}