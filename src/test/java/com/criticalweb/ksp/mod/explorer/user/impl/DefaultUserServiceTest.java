package com.criticalweb.ksp.mod.explorer.user.impl;

import com.criticalweb.ksp.mod.explorer.entities.User;
import com.criticalweb.ksp.mod.explorer.security.SecurityService;
import com.criticalweb.ksp.mod.explorer.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Francois Levesque <francois@critical-web.com>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-core-test.xml")
@WebAppConfiguration
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class DefaultUserServiceTest {

	@Resource
	UserService userService;

	@Test
	public void testGetUserByLogin() {

		String username = "test-user-1";
		String password = "123";

		User user = userService.createNewUser(username, password, "test-user-email-1@critical-web.com", username);

		String salt = user.getSalt();

		try {
			User userFromLogin = userService.getUserByLogin(username, password);

			assertEquals("Incorrect user returned!", user, userFromLogin);

		} catch (EntityNotFoundException e) {
			fail("User not found!");
		}

	}

}
