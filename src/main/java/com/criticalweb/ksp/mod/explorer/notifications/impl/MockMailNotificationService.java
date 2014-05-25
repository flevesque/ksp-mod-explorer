package com.criticalweb.ksp.mod.explorer.notifications.impl;

import com.criticalweb.ksp.mod.explorer.entities.User;
import com.criticalweb.ksp.mod.explorer.notifications.NotificationService;
import com.criticalweb.ksp.mod.explorer.notifications.NotificationStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Francois Levesque <francois@critical-web.com>
 */
@Component
public class MockMailNotificationService implements NotificationService {

	@Resource
	MessageSource messageSource;

	private static Logger LOG = LoggerFactory.getLogger(MockMailNotificationService.class);

	@Override
	public NotificationStatus sendRegistrationMessage(User user, String baseUrl) {

		StringBuilder sb = new StringBuilder();
		sb.append(baseUrl).append("/login/activate/").append(user.getActivationkey());

		String[] args = {user.getDisplayname(), sb.toString()};

		String message = messageSource.getMessage("form.register.notification", args, LocaleContextHolder.getLocale());

		LOG.info("\n" + message);

		return null;
	}

}
