package com.criticalweb.ksp.mod.explorer.session.impl;

import com.criticalweb.ksp.mod.explorer.entities.User;
import com.criticalweb.ksp.mod.explorer.session.SessionService;
import com.criticalweb.ksp.mod.explorer.session.SessionUser;
import org.springframework.stereotype.Component;

/**
 * Created by Francois Levesque <francois@critical-web.com>
 */
@Component
public class DefaultSessionService implements SessionService{

	@Override
	public SessionUser setUser(User user) {

		SessionUser sessionUser = new SessionUser();
		sessionUser.setUsername(user.getUsername());
		sessionUser.setDisplayname(user.getDisplayname());
		sessionUser.setEmail(user.getEmail());
		sessionUser.setActive(user.isActive());

		return sessionUser;
	}
}
