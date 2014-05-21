package com.criticalweb.ksp.mod.explorer.security.impl;

import com.criticalweb.ksp.mod.explorer.security.HashResponse;
import com.criticalweb.ksp.mod.explorer.security.SecurityService;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by Francois Levesque <francois@critical-web.com>
 */
@Component
public class DefaultSecurityService implements SecurityService {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultSecurityService.class);

	@Override
	public String hash(String source, String salt) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			return Base64.encodeBase64URLSafeString(digest.digest((salt+source).getBytes()));
		} catch (NoSuchAlgorithmException e) {
			LOG.error("Error hashing source string! Value is still clear text! " + e.getMessage());
			return source;
		}
	}

	@Override
	public HashResponse hash(String source) {
		HashResponse response = new HashResponse();
		String salt = getSalt();
		response.setSalt(salt);
		response.setHashed(hash(source, salt));
		return response;
	}

	private static String getSalt() {
		int size = 16;
		byte[] bytes = new byte[size];
		new Random().nextBytes(bytes);
		return Base64.encodeBase64URLSafeString(bytes);
	}

}
