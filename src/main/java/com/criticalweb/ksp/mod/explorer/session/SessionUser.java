package com.criticalweb.ksp.mod.explorer.session;

import org.springframework.context.annotation.Scope;

/**
 * Created by Francois Levesque <francois@critical-web.com>
 */
@Scope("session")
public class SessionUser {

	private String username;
	private String displayname;
	private String email;
	private boolean active;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
