package com.gcu.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterModel {
	    @NotBlank(message = "Name is required")
	    private String name;

	    @Email(message = "Invalid email format")
	    @NotBlank(message = "Email is required")
	    private String email;

	    @NotBlank(message = "Username is required")
	    private String username;

	    @Size(min = 6, message = "Password must be at least 6 characters long")
	    @NotBlank(message = "Password is required")
	    private String password;

	    @Size(min = 6, message = "Confirm password must be at least 6 characters long")
	    @NotBlank(message = "Confirm password is required")
	    private String confirmPassword;

	    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number format")
	    @NotBlank(message = "Mobile number is required")
	    private String mobileNumber;
	    
	    
    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}