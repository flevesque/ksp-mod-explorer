package com.criticalweb.ksp.mod.explorer.security;

/**
 * Created by Francois Levesque <francois@critical-web.com>
 */
public class HashResponse {

	private String hashed;
	private String salt;

	public String getHashed() {
		return hashed;
	}

	public void setHashed(String hashed) {
		this.hashed = hashed;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
}
