package com.interviewmiles.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UserCreateForm {
	
	@NotNull
	@NotEmpty
	private String email = "";
	
	@NotNull
	@NotEmpty
	private String password ="";
	
	@NotNull
	@NotEmpty
    private String passwordRepeated ="";
    
	@NotNull
	private Role role = Role.USER;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	public void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
    
	
}
