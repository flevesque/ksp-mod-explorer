package com.criticalweb.ksp.mod.explorer.security;

/**
 * Created by Francois Levesque <francois@critical-web.com>
 */
public interface SecurityService {

	public String hash(String source, String salt);

	public HashResponse hash(String source);

}
