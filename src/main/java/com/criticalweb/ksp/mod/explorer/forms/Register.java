package com.criticalweb.ksp.mod.explorer.forms;

import com.criticalweb.ksp.mod.explorer.forms.validation.MustMatch;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author Francois Levesque <francois@critical-web.com>
 * @since 1.0
 */
@MustMatch(first = "password", second = "confirmPassword", message = "{MustMatch.register.password}")
public class Register {

	@NotNull @NotEmpty
	private String username;

	@NotNull @NotEmpty
	private String password;

	@NotNull @NotEmpty
	private String confirmPassword;

	@NotNull @NotEmpty
	private String displayname;

	@NotNull @NotEmpty @Email
	private String email;

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

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
