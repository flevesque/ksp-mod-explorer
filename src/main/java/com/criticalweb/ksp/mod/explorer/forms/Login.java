package com.criticalweb.ksp.mod.explorer.forms;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author Francois Levesque <francois@critical-web.com>
 */
public class Login {

	@NotNull @NotEmpty
	private String username;

	@NotNull @NotEmpty
	private String password;

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
}
